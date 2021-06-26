package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static MySQLConnection instance;

    static String DB_URL = "jdbc:mysql://localhost:3306/practice",
        USERNAME = "root",
        PASSWORD = "password";

    private Connection connection;

    private MySQLConnection(String connectionUrl, String username, String password) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(connectionUrl,username, password);
            this.connection = connection;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static MySQLConnection getInstance() throws SQLException, ClassNotFoundException {
        if(instance == null || instance.connection.isClosed()) {
            instance = new MySQLConnection(DB_URL, USERNAME, PASSWORD);
        }

        return instance;
    }
}
