package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {
    private static List<Connection> freeDbConnections;

        static {
            freeDbConnections = new LinkedList<Connection>();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("DB driver not found");
            }
        }

        private static Connection createDbConnection() throws SQLException {
            Connection newConnection = null;
            String db = "quartumopus";
            String username = "root";
            String password = "SperiamoPassoBD22!";
            newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,username,password);
            System.out.println("Create new DB connection");
            newConnection.setAutoCommit(true);
            return newConnection;
        }

        /**
         * Il metodo restituisce una connessione dal suo pool di connessioni libere.
         * @return connessione libera
         */

        public static synchronized Connection getConnection() throws SQLException {
            Connection connection;
            if (!freeDbConnections.isEmpty()) {
                connection = (Connection) freeDbConnections.get(0);
                DriverManagerConnectionPool.freeDbConnections.remove(0);
                try {
                    if (connection.isClosed()) {
                        connection = DriverManagerConnectionPool.getConnection();
                    }
                } catch (SQLException e) {
                    connection.close();
                    connection = DriverManagerConnectionPool.getConnection();
                }
            } else {
                connection = DriverManagerConnectionPool.createDbConnection();
            }

            return connection;
        }

        /**
         * Il metodo rilascia la connessione inviata e la riposiziona
         * nell'array di connessioni libere.
         * @param connection connessione da liberare
         */

        public static synchronized void releaseConnection(Connection connection) throws SQLException {
            if (connection != null) {
                DriverManagerConnectionPool.freeDbConnections.add(connection);
            }
        }

}

