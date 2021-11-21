package com.company;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "0035"
            );

            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;

            rowsAffected = statement.executeUpdate(
                    "INSERT INTO java_programming VALUES (55, 'carl davis', 61)");
            rowsAffected = statement.executeUpdate(
                    "INSERT INTO java_programming VALUES (66, 'dennis fredrickson', 88)");
            rowsAffected = statement.executeUpdate(
                    "INSERT INTO java_programming VALUES (77, 'jane richards', 78)");

            results = statement.executeQuery("SELECT * FROM java_programming where grade>60 and grade<80");
            while (results.next()) {
                System.out.println(results.getInt("id")+" "+results.getString("name")
                        +" "+results.getInt("grade"));
            }
            rowsAffected = statement.executeUpdate(
                    "UPDATE java_programming SET grade=65 WHERE name='carl davis'");
            rowsAffected = statement.executeUpdate(
                    "DELETE FROM java_programming WHERE name='dennis fredrickson'");
            rowsAffected = statement.executeUpdate(
                    "UPDATE java_programming SET grade=80 WHERE id>55");
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
