package com.company;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "12345678"
            );

            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;
            //Insert the following 3 new rows into the java_programming table:

            rowsAffected = statement.executeUpdate(
                    "INSERT INTO java_programming VALUES (55, 'Carl Davis', 61),(66,'Dennis Fredrichkson',88),(77,'Jane Richards',78)");
            //Select all records with a grade between 60 and 80.:
            results = statement.executeQuery("SELECT * FROM java_programming");
            while (results.next()) {
                System.out.println(results.getInt("ID") + ", "+results.getString("Name")+", "+results.getInt("Grade"));
            }
            //Change Carl Davis’s grade to 65.
            rowsAffected = statement.executeUpdate(
                    "UPDATE java_programming SET Grade=65 WHERE id=66"
            );
            //Delete Dennis Fredrickson’s row.
            rowsAffected = statement.executeUpdate(
                    "DELETE FROM java_programming WHERE id=66"
            );
            //Change the grade of all people with an id greater than 55 to 80.
            rowsAffected = statement.executeUpdate(
                    "UPDATE java_programming SET Grade=100 WHERE id > 55 and id < 80"
            );


            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }




        // write your code here
    }
}
