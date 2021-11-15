package JoinDataFromDB;

import java.sql.*;

public class SelectManagersUsers {

    private static final String URL = "jdbc:mysql://localhost:3306/myjoindb";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "123456789";

    private static final String GET_DATA = "select u.name, u.surname, u.phone, p.bdate from users u\n" +
            "join profile_users p ON u.id=p.user_id\n" +
            "join position o ON o.user_id=u.id\n" +
            "where o.position='manager';";

    public static void main(String[] args) {
        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(GET_DATA);

            ResultSet rs = statement.executeQuery();


            while (rs.next()) {
                String name = rs.getString(1);
                String surname = rs.getString(2);
                String phone = rs.getString(3);
                String bdate = rs.getString(4);

                System.out.println(name + " " + " " + surname + " " + phone
                        + " " + bdate);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
