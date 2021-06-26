package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateRestaurant {
    public static void main(String[] args) throws Exception {
        Connection connection = MySQLConnection.getInstance().getConnection();

        try {
            InsertCmd insertCmd = new InsertCmd(connection, Queries.CREATE_NEW_RESTAURANT);

            insertCmd.setParamters("McDonalds Drive-thru NH48 Manesar", "McDonalds", "MCD-MANESAR-FRANCHISE ENTERPRISE PVT. LTD.",
                    "122505", "NH8 Manesar, Gurgaon", "NH8 Manesar, Gurgaon", "ACTIVE", "ONLINE", "0124654300");
            insertCmd.executeUpdate();
            insertCmd.close();
            System.out.println("Restaurant created.");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
