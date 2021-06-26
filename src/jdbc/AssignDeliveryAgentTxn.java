package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 * Steps:
 * 1. Find closest delivery agent with status = AVAILABLE
 * 2. Update order with delivery agent identifier
 * 3. Update status of delivery agent to OCCUPIED
 */
public class AssignDeliveryAgentTxn {
    public static void main(String[] args) throws Exception {
        Connection connection = MySQLConnection.getInstance().getConnection();
        int orderId = 1;

        connection.setAutoCommit(false);

        try {
            Integer deliveryAgentId = getAvailableDeliveryAgentId(connection);

            if(Objects.isNull(deliveryAgentId))
                throw new Exception("Could not find available delivery agent at " + new Date());

            assignDeliveryAgentToOrder(connection, orderId, deliveryAgentId);
            updateDeliveryAgentOpsStatus(connection, deliveryAgentId, "OCCUPIED");
            log("Committing...");
            connection.commit();
        } catch (SQLException ex) {
            log(ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        } catch (Exception ex) {
            log(ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }

    }

    private static void log(Object printable) { System.out.println(printable); }

    static Integer getAvailableDeliveryAgentId(Connection connection) throws SQLException {
        SelectCmd selectCmd = new SelectCmd(connection, Queries.FIND_AVAILABLE_DELIVERY_AGENT);
        ResultSet resultSet = selectCmd.executeQuery();

        if(resultSet.next()) {
            return resultSet.getInt("id");
        }

        return null;
    }

    static Integer assignDeliveryAgentToOrder(Connection connection, int order_id, int delivery_agent_id) throws SQLException {
        InsertCmd insertCmd = new InsertCmd(connection, Queries.ASSIGN_DELIVERY_AGENT_TO_ORDER);
        insertCmd.setParamters(delivery_agent_id, order_id);
        return insertCmd.executeUpdate();
    }

    static Integer updateDeliveryAgentOpsStatus(Connection connection, int delivery_agent_id, String status) throws SQLException {
        InsertCmd insertCmd = new InsertCmd(connection, Queries.UPDATE_DELIVERY_AGENT_OPS_STATUS);
        insertCmd.setParamters(status, delivery_agent_id);
        return insertCmd.executeUpdate();
    }
}
