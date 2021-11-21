package com.company;

import java.sql.*;


public class Main {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Cout123123"
            );

            Statement statement = connection.createStatement();
            ResultSet result;

//            String sql = "CREATE TABLE java_programming " +
//                    "(id INTEGER not NULL, " +
//                    " name VARCHAR(255), " +
//                    " grade INTEGER , " +
//                    " PRIMARY KEY ( id ))";
//            statement.executeUpdate(sql);
//
//            statement.executeUpdate("INSERT INTO java_programming " +
//                    "VALUES (55, 'Carl Davis', 61) , " +
//                    "(66, 'Dennis Fredrickson', 88) ," +
//                    "(77, 'Jane Richards', 78)") ;


            //Select all records with a grade between 60 and 80.
//            result = statement.executeQuery("SELECT * FROM java_programming WHERE grade BETWEEN 60 AND 80");
//            while (result.next()){
//                System.out.print(result.getString("id") + " ");
//                System.out.print(result.getString("name") + " ");
//                System.out.println(result.getString("grade"));
//            }

            //Change Carl Davis’s grade to 65.
//            statement.executeUpdate(" UPDATE java_programming SET grade = 65 WHERE name = 'Carl Davis'");
//            result = statement.executeQuery("SELECT * FROM java_programming ");
//            while (result.next()){
//                System.out.print(result.getString("id") + " ");
//                System.out.print(result.getString("name") + " ");
//                System.out.println(result.getString("grade"));
//            }

            //Delete Dennis Fredrickson’s row.
//            statement.executeUpdate(" DELETE FROM java_programming WHERE name = 'Dennis Fredrickson' ");
//            result = statement.executeQuery("SELECT * FROM java_programming ");
//            while (result.next()){
//                System.out.print(result.getString("id") + " ");
//                System.out.print(result.getString("name") + " ");
//                System.out.println(result.getString("grade"));
//            }

            //Change the grade of all people with an id greater than 55 to 80.
//            statement.executeUpdate(" UPDATE java_programming SET grade = 90 WHERE id BETWEEN 55 AND 80");
//            result = statement.executeQuery("SELECT * FROM java_programming ");
//            while (result.next()){
//                System.out.print(result.getString("id") + " ");
//                System.out.print(result.getString("name") + " ");
//                System.out.println(result.getString("grade"));
//            }



            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
