package dao;

import java.sql.*;

public class DbConnector {
    private static final String url = "jdbc:mysql://localhost:3306/madb?useSSL=false&serverTimezone=UTC";
    private static final String name = "root";
    private static final String pass = "root";

    public static Connection connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
