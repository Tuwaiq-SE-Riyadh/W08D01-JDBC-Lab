package com.company;

import java.sql.*;

public class Main {



    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "14171417"
            );

            Statement statement = connection.createStatement();

            ResultSet results;
            int rowsAffected;

            rowsAffected = statement.executeUpdate("INSERT INTO java_programming (id , name , grade ) VALUES (55, 'Carl Davis', 61 ) , (66, 'Dennis Fredrickson', 88 ) , (77, 'Jane Richards', 78 )");

            results = statement.executeQuery("SELECT * FROM java_programming WHERE grade BETWEEN 60 and 80 ;");


            while (results.next()) {

                System.out.printf(results.getInt("id") + " , " + results.getString("name") + " , " + results.getInt("grade"));
            };

            rowsAffected = statement.executeUpdate("UPDATE java_programming SET name = 'Carl Davis', grade = 65 WHERE id = 55");

            rowsAffected = statement.executeUpdate("DELETE FROM java_programming WHERE name = 'Dennis Fredrickson'");

            rowsAffected = statement.executeUpdate("UPDATE java_programming SET grade = 100 WHERE id > 55 AND id < 88");


            results.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
