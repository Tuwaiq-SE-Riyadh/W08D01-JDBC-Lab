package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "1234"
            );

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM java_programming");
//            int rowsAffect = statement.executeUpdate("INSERT INTO java_programming VALUES(55,'carl davos',61)");
//            System.out.println("Querey Complete " + rowsAffect + " rows added");
//            rowsAffect = statement.executeUpdate("INSERT INTO java_programming VALUES(66,'Dennis dd',70)");
//            System.out.println("Querey Complete " + rowsAffect + " rows added");
//            rowsAffect = statement.executeUpdate("INSERT INTO java_programming VALUES(77,'Dontcare',999)");
//            System.out.println("Querey Complete " + rowsAffect + " rows added");
            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString("name") + " " + result.getInt(3));
            }

            System.out.println("SELECT * FROM java_programming where grade>60 and grade<80");
            result = statement.executeQuery("SELECT * FROM java_programming where grade>60 and grade<80");
            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString("name") + " " + result.getInt(3));
            }

            System.out.println("SELECT * FROM java_programming where grade>60 and grade<80");
//            int res = statement.executeUpdate("UPDATE  java_programming set grade =65 where name ='Dennis dd'");
            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString("name") + " " + result.getInt(3));
            }
            int res = statement.executeUpdate("DELETE rom  java_programming where  name =Dennis dd");
            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString("name") + " " + result.getInt(3));
            }
            

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
