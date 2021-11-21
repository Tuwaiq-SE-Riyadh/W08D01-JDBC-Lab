package com.company;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "80088008"
            );

            Statement statement = connection.createStatement();

//            statement.close();
//            connection.close();
            ResultSet results;
            int rowsAffected;

//            results = statement.executeQuery("SELECT * FROM java_programming WHERE grade > 60 && grade < 80");
            results = statement.executeQuery("SELECT * FROM java_programming");
            while (results.next()){
                System.out.println(results.getInt("id")+" , "+results.getString("name")+" , "+results.getInt("grade"));
            }


                rowsAffected = statement.executeUpdate("UPDATE java_programming SET grade = 65 WHERE id = 55");
                System.out.println("Query complete, "+rowsAffected+" rows updated.");
                printAllFromTable(statement);
                rowsAffected = statement.executeUpdate("DELETE FROM java_programming WHERE id = 66");
                System.out.println("Query complete, "+rowsAffected+" rows removed.");
                printAllFromTable(statement);

                rowsAffected = statement.executeUpdate("UPDATE java_programming SET grade = 80  WHERE id > 55");
                System.out.println("Query complete, "+rowsAffected+" rows updated.");
                printAllFromTable(statement);


//            printAllFromTable(statement);
            results.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void printAllFromTable(Statement statement) throws SQLException{

        ResultSet results = statement.executeQuery("SELECT * FROM java_programming");
        while(results.next()){
            System.out.println(results.getInt("id")+", "+results.getString("name")+", "+results.getInt("grade"));
        }

    }
}
