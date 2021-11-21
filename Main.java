package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Faisal1411");
            Statement statement = connection.createStatement();
//            String q1 = "CREATE TABLE java_programming (id int, name varchar(30), grade int, primary key (id))";
//            statement.executeUpdate(q1);
            String q2 = "INSERT INTO java_programming VALUES(55,'Carl Davis', 61)";
            statement.executeUpdate(q2);
            String q3 = "INSERT INTO java_programming VALUES(66,'Dennis Fredrickson', 88)";
            statement.executeUpdate(q3);
            String q4 = "INSERT INTO java_programming VALUES(77,'Jane Richards', 78)";
            statement.executeUpdate(q4);

            ResultSet results;
            results = statement.executeQuery("SELECT * FROM java_programming WHERE grade BETWEEN 60 AND 80");
            while(results.next()){
                System.out.println(results.getInt("id") + " -- " + results.getString("name") + " -- " + results.getInt("grade"));
            }

            String q5 = "UPDATE java_programming SET grade = 65 WHERE name = 'Carl Davis'";
            int x = statement.executeUpdate(q5);
            System.out.println(x + " Rows Updated");

            String q6 = "DELETE FROM java_programming WHERE name = 'Dennis Fredrickson'";
            x = statement.executeUpdate(q6);
            System.out.println(x + " Rows Deleted");

            String q7 = "UPDATE java_programming set grade = 90 WHERE id >= 55 AND id <= 80;";
            x = statement.executeUpdate(q7);
            System.out.println(x + " Rows Updated");

            results = statement.executeQuery("SELECT * FROM java_programming");
            System.out.println("Table After Queries:");
            while(results.next()){
                System.out.println(results.getInt("id") + " -- " + results.getString("name") + " -- " + results.getInt("grade"));
            }

            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
