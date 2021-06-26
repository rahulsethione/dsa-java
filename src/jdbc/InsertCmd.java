package jdbc;

import java.sql.Connection;
import java.sql.SQLException;


public class InsertCmd extends SqlCmd {

    public InsertCmd(Connection connection, String sql) throws SQLException {
        super(connection, sql);
    }
}
