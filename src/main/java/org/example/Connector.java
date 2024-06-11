package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector {
    private static final String url = "jdbc:mysql://localhost:3306/livraria";
    private static final String userName = "root";
    private static final String password = "filipe2374";

    private static Connector conector;
    private Connection conn;

    public Connector() {
        conn = createConnection();
    }

    private Connection createConnection() {
        Connection connection = null;
        try {
//            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connector getInstance() {
        if (conector == null) {
            conector = new Connector();
        }
        return conector;
    }

    public Connection getConector() {
        return conn;
    }

    public void fecharConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {

        // The commented line below was necessary until Java SE 5 in order to load the driver in memory
        // Class.forName("com.mysql.jdbc.Driver");

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Successfully connected to MySQL!");
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
