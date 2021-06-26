package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class SelectCmd extends SqlCmd {

    public SelectCmd(Connection connection, String sql) throws SQLException {
        super(connection, sql);
    }
}
