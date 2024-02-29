package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://b4now7wdtoyzl6ztexpz-mysql.services.clever-cloud.com:3306/b4now7wdtoyzl6ztexpz";
    private static final String USUARIO = "uksiuyrf6oojoehk";
    private static final String SENHA = "AFgsgZFGcOf2Omlvl2ZY";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
