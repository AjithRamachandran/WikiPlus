package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class database {
    private Connection connection;

    public database() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/user_data.db");
        } catch ( Exception ignored) {
        }
    }

    public int signIn(String userName, String passWord) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "SELECT pWord from user_data where uName =" + userName + ";";
        try {
            ResultSet result = stmt.executeQuery(sql);
            String pass = result.getString("pWord");
            System.out.println(pass);
            System.out.println(passWord);
            if (!pass.equals(passWord)) {
                stmt.close();
                connection.commit();
                connection.close();
                return -1;
            } else {
                connection.commit();
                connection.close();
                stmt.close();
                return 0;
            }

        } catch (Exception e) {
            stmt.close();
            return -1;
        }
    }

    public int signUp(String firstName, String lastName, String userName, String passWord) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "INSERT INTO user_data (fName, lName, uName, pWord) VALUES ('" + firstName + "','" + lastName + "','" + userName + "','" + passWord + "');";
        try {
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            stmt.close();
            return -1;
        }
        stmt.close();
        return 0;
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
    }
}
