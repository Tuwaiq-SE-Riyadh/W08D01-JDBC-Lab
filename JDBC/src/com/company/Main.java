package com.company;

import java.sql.*;
public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "14251407"
            );

            Statement statement = connection.createStatement();

            ResultSet result ;
            int rowsAffected;
            result = statement.executeQuery("select * from java_programming where grade between 60 and 80");

            while (result.next()){
                System.out.println(result.getString("id")+result.getString("name")
            +result.getInt("grade"));

            }

            rowsAffected = statement.executeUpdate(
                    "UPDATE java_programming SET grade=65 WHERE id=66"
            );
            System.out.println("Query complete, " + rowsAffected + " rows updated.");
                    printAllFromTable(statement);




            rowsAffected = statement.executeUpdate(
                    "DELETE FROM java_programming WHERE id=66"
            );
            System.out.println("Query complete, " + rowsAffected + " rows removed.");
                    printAllFromTable(statement);


            rowsAffected = statement.executeUpdate(
                    "UPDATE java_programming SET grade=80 WHERE id>55"
            );
            System.out.println("Query complete, " + rowsAffected + " rows updated.");
            printAllFromTable(statement);



            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    public static void printAllFromTable(Statement statement) throws SQLException{
        ResultSet results = statement.executeQuery("SELECT id,name,grade FROM java_programming ");
        while (results.next()) {
            System.out.println(
                    results.getInt("id") + ", "
                            + results.getString("name") + ", "
                            + results.getString("grade") + ", "

            );
        }
    }
}


