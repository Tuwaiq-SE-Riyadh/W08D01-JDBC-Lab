package Java;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "12345678"
            );

            Statement statement = connection.createStatement();

            ResultSet results;
            int rowsAffected;
            //1)Insert the following 3 new rows into the java_programming table:
//           int rowsAffected = statement.executeUpdate(
//            "INSERT INTO  java_programming  VALUES (55,'Carl Davis',61) ,(66,'Dennis Fredrickson',88),(77,'Jane Richards',78);");
//            System.out.println("Query complete, " + rowsAffected + " rows added.");
            //print all java_programming
            results = statement.executeQuery("SELECT * FROM java_programming ");
            // Loop over the results, printing them all.
            while (results.next()){
                System.out.println(results.getString("name") + ", "
                        +results.getInt("grade"));
            }

            //2)Select all records with a grade between 60 and 80.
            results = statement.executeQuery("SELECT * FROM java_programming where grade between 60 And 80");
            // Loop over the results, printing them all.
            while (results.next()){
                System.out.println(results.getString("name") + ", "
                        +results.getInt("grade"));
            }

            //3)Change Carl Davis’s grade to 65.
//            rowsAffected = statement.executeUpdate(
//                    "UPDATE java_programming SET grade=65 WHERE id=56"
//            );
//            System.out.println("Query complete, " + rowsAffected + " rows updated.");

           // 4)Delete Dennis Fredrickson’s row.
//            rowsAffected = statement.executeUpdate(
//                    "DELETE from java_programming WHERE NAME='Dennis Fredrickson'"
//            );
//            System.out.println("Query complete, " + rowsAffected + " rows updated.");

            //5) Change the grade of all people with an id greater than 55 to 80.
//            rowsAffected = statement.executeUpdate(
//                   "UPDATE java_programming SET grade=100 WHERE id>55 and id <80");
//            System.out.println("Query complete, " + rowsAffected + " rows updated.");


                    statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}