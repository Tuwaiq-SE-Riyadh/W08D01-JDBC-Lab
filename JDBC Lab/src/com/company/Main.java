package com.company;
import java.sql.*;
public class Main {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testjava?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "123456"
            );

            Statement statement = connection.createStatement();




            ResultSet results;
            int rowsAffected;
//INSERT INTO table_name (column1, column2, column3, ...)
//VALUES (value1, value2, value3, ...);Dennis Fredrickson
//            rowsAffected=statement.executeUpdate("INSERT INTO java_programming(id,name,grade) VALUES (55,'Carl Davis',61);");
            rowsAffected=statement.executeUpdate("INSERT INTO java_programming(id,name,grade) VALUES (66,'Dennis Fredrickson',88);");
//            rowsAffected=statement.executeUpdate("INSERT INTO java_programming(id,name,grade) VALUES (77,'Jan Riched',78);");


//            Q1
            results= statement.executeQuery("select * from java_programming where grade  BETWEEN 60 AND 80 ;");
            System.out.println("Q1");
            while (results.next()){
                System.out.println(results.getString("name"));
            }
            results.close();
//            =====================================================================
//            Q2
            System.out.println("Q2");

            rowsAffected= statement.executeUpdate("UPDATE java_programming SET grade=65 WHERE name='Carl Davis' ;");
            results=statement.executeQuery("select * from java_programming");
            while (results.next()){
                System.out.println(results.getString("name") +","+results.getInt("grade"));
            }

            results.close();



//=======================================================================================
//            Q3
            System.out.println("Q3");

            rowsAffected= statement.executeUpdate("DELETE FROM java_programming WHERE name='Dennis Fredrickson' ;");
            results=statement.executeQuery("select * from java_programming ");
            while (results.next()){
                System.out.println(results.getString("name") +","+results.getInt("grade"));
            }

            results.close();

//            ==========================================================================
//            Q4
            System.out.println("Q4");

            rowsAffected= statement.executeUpdate("UPDATE java_programming SET grade=90 where id  BETWEEN 55 AND 80;");
            results=statement.executeQuery("select * from java_programming ");
            while (results.next()){
                System.out.println(results.getString("name") +","+results.getInt("grade"));
            }

            results.close();


            statement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
