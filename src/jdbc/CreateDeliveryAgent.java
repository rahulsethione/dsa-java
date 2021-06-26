package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateDeliveryAgent {
    public static void main(String[] args) throws Exception {
        Connection connection = MySQLConnection.getInstance().getConnection();

        try {
            InsertCmd insertCmd = new InsertCmd(connection, Queries.CREATE_NEW_DELIVERY_AGENT);

            insertCmd.setParamters("Rahul Kumar", "8979343412", "ACTIVE");
            insertCmd.executeUpdate();
            insertCmd.close();
            System.out.println("Delivery agent created.");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
