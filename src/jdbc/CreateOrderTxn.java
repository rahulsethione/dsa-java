package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Steps:
 * 1. Create order for a CUSTOMER for a selected MENU ITEMS from RESTAURANT of choice
 * 2. Then check for AVAILABLE Delivery Agent who can pick the order from the restaurant and map him/her to the order
 */

public class CreateOrderTxn {
    public static void main(String[] args) throws Exception {
        int customer_id = 1;
        int restaurant_id = 1;
        int[] menu_item_ids = new int[] {1, 5};
        int[] menu_item_quantities = new int[] {2, 2};

        Connection connection = MySQLConnection.getInstance().getConnection();

        connection.setAutoCommit(false);
        try {

            SelectCmd selectMenuItems = new SelectCmd(connection, Queries.FIND_MENU_ITEMS_IN);

            selectMenuItems.setParamters(menu_item_ids[0]); // Hack

            ResultSet menuItemsResultSet = selectMenuItems.executeQuery();

            float amount = 0f;

            while (menuItemsResultSet.next()) {
                int menuItemId = menuItemsResultSet.getInt("menu_item_id");
                float price = menuItemsResultSet.getFloat("price");
                int index = 0;

                for(int i = 0; i < menu_item_ids.length; i++) {
                    if(menu_item_ids[i] == menuItemId) {
                        index = i;
                        break;
                    }
                }

                amount += price * menu_item_quantities[index];
            }

            InsertCmd insertNewOrder = new InsertCmd(connection, Queries.CREATE_NEW_ORDER);

            insertNewOrder.setParamters(customer_id, restaurant_id, amount, 0f);
            insertNewOrder.executeUpdate();

            SelectCmd selectLastOrder = new SelectCmd(connection, Queries.FIND_LAST_CREATED_ORDER);
            ResultSet lastOrderResultSet = selectLastOrder.executeQuery();
            int order_id;

            if(lastOrderResultSet.next()) {
                order_id = lastOrderResultSet.getInt("order_id");
            } else {
                throw new Exception("Unexpected Exception");
            }

            for(int i = 0; i < menu_item_ids.length; i++) {
                InsertCmd insertOrderItem = new InsertCmd(connection, Queries.CREATE_NEW_ORDER_ITEM);

                insertOrderItem.setParamters(order_id, menu_item_ids[i], 1f, 0f, menu_item_quantities[i]);

                insertOrderItem.executeUpdate();
            }

            connection.commit();
            System.out.println("Order placed.");
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }
    }
}
