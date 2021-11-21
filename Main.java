package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "12345"
            );

            Statement statement = connection.createStatement();

            ResultSet result;
            int rowAffected;

            result = statement.executeQuery("SELECT * FROM java_programming");
            while (result.next()){
                System.out.println(result.getInt("id"));
            }

            rowAffected=statement.executeUpdate("INSERT INTO java_programming VALUES('55','Carl Davis','61')");
            rowAffected=statement.executeUpdate("INSERT INTO java_programming VALUES('66','Dennis Fredrikchson','88')");
            rowAffected=statement.executeUpdate("INSERT INTO java_programming VALUES('77','Jane Richards','78')");

            System.out.println("Query complete" + rowAffected+" rows added");



            rowAffected=statement.executeUpdate("UPDATE java_programming SET grade='65' WHERE name='Carl Davis'");
            System.out.println("Query complete" + rowAffected+" rows added");





            rowAffected=statement.executeUpdate("DELETE FROM java_programming WHERE name='Dennis Fredrikchson'");
            System.out.println("Query complete " + rowAffected+" rows added");
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
