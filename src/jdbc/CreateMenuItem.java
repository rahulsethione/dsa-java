package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateMenuItem {
    public static void main(String[] args) throws Exception {
        Connection connection = MySQLConnection.getInstance().getConnection();

        try {
            InsertCmd insertCmd = new InsertCmd(connection, Queries.CREATE_NEW_MENU_ITEM);

            insertCmd.setParamters(1, "McChicken Tikka Burger Non-veg", 65.50, 1, 1, "Spicy Chicken Tikki Non-Veg Burger");
            insertCmd.executeUpdate();
            insertCmd.close();
            System.out.println("Menu item created.");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
