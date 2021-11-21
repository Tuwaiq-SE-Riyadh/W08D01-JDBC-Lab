package com.company;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "noura123"
            );

            Statement statement = connection.createStatement();
            ResultSet result;
            int RowEffect;
//            String table="CREATE TABLE java_programming(ID int NOT NULL,"
//                            +"NAME varchar(255),"
//                            +"GRADE int,"
//                            +"PRIMARY KEY (ID))";
//            statement.execute(table);
//            System.out.println("table created");
//            RowEffect= statement.executeUpdate("INSERT INTO java_programming VALUES (55,'Carl Davis',61)");
//            RowEffect=statement.executeUpdate("INSERT INTO java_programming VALUES(66,'Dennis Fredrickson',88)");
//            RowEffect=statement.executeUpdate("INSERT INTO java_programming VALUES(77,'Jane Richards',78)");
//            System.out.println("Query complete, " + RowEffect + " rows added.");

//                result = statement.executeQuery("SELECT * FROM java_programming WHERE GRADE BETWEEN 60 AND 80");
//                while (result.next()) {
//                System.out.println(result.getInt("ID") + ", " + result.getString("NAME") + ", " + result.getInt("GRADE"));
//            }
//            RowEffect = statement.executeUpdate("UPDATE java_programming SET GRADE=65 WHERE NAME='Carl Davis';");
//            System.out.println("Query complete, " + RowEffect + " rows updated.");
//            RowEffect = statement.executeUpdate("DELETE FROM java_programming WHERE NAME='Dennis Fredrickson';");
//            System.out.println("Query complete, " + RowEffect + " rows deleted.");
            RowEffect = statement.executeUpdate("UPDATE java_programming SET GRADE=80 WHERE ID>55;");
            System.out.println("Query complete, " + RowEffect + " rows updated.");
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
