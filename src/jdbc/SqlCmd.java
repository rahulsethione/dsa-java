package jdbc;

import java.sql.*;

public abstract class SqlCmd {
    protected final PreparedStatement preparedStatement;

    public SqlCmd(Connection connection, String sql) throws SQLException {
        this.preparedStatement = connection.prepareStatement(sql);
    }

    public ResultSet executeQuery() throws SQLException {
        return preparedStatement.executeQuery();
    }

    public int executeUpdate() throws SQLException {
        return preparedStatement.executeUpdate();
    }

    public void setParamters(Object ...params) throws SQLException {
        for(int i = 0; i < params.length; i++) {
            Object param = params[i];
            int index = i + 1;

            if(param instanceof String) {
                preparedStatement.setString(index, (String) param);
            } else if(param instanceof Integer) {
                preparedStatement.setInt(index, (Integer) param);
            } else if(param instanceof Float) {
                preparedStatement.setFloat(index, (Float) param);
            } else if(param.getClass().isArray()) {
                preparedStatement.setArray(index, (Array) param);
            } else {
                preparedStatement.setString(index, param.toString());
            }

        }
    }

    public void close() throws SQLException {
        if(preparedStatement != null) {
            preparedStatement.close();
        }
    }
}
