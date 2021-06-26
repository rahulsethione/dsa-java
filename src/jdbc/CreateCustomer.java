package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateCustomer {
    public static void main(String[] args) throws Exception {
        Connection connection = MySQLConnection.getInstance().getConnection();

        try {
            InsertCmd insertCmd = new InsertCmd(connection, Queries.CREATE_NEW_USER);

            insertCmd.setParamters("James Jameson", "jamesjameson@gmail.com", "8955885588");
            insertCmd.executeUpdate();
            insertCmd.close();
            System.out.println("Customer created.");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
