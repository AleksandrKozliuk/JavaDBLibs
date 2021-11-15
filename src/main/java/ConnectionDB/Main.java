package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/myjoindb";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "123456789";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Correct connection to db!");
            }

            connection.close();

            if (connection.isClosed()) {
                System.out.println("Connection closed :(");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}