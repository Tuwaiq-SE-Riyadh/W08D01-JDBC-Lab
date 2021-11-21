package ConnectDatabase;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Shshrooq1212123"
            );
            Statement statement = connection.createStatement();

            // Q1
//            int rowsAffected = statement.executeUpdate("INSERT INTO java_programming VALUES (55, 'Carl Davis', 61)," +
//                    "(66,'Dennis Fredrickson', 88), (77, 'Jane Richards', 78)");
//            System.out.println("Query complete, " + rowsAffected + " rows added.");
            // Q2
            ResultSet programmer = statement.executeQuery("SELECT * FROM java_programming WHERE grade BETWEEN 60 AND 80");
            while (programmer.next()) {
                System.out.println(programmer.getString("id") +" "+ programmer.getString("name") +" "+ programmer.getString("grade"));
            }

            // Q3
            int rowsAffected = statement.executeUpdate("UPDATE java_programming SET grade =65 WHERE name = 'Carl Davis' ");
            if (rowsAffected == 0) {
                System.out.println("Query not completed");
            } else {
                System.out.println("Query complete, " + rowsAffected + " rows updated.");
            }

//          // Q4
            rowsAffected = statement.executeUpdate("DELETE FROM java_programming WHERE name = 'Dennis Fredrickson' ");
            if (rowsAffected == 0) {
                System.out.println("statement not completed");
            } else {
                System.out.println("Query complete, " + rowsAffected + " rows deleted.");
            }

            //Q5 Change the grade of all people with an id greater than 55 to 80.
             rowsAffected = statement.executeUpdate("UPDATE java_programming SET grade = 80 WHERE id > 55 ");
            if (rowsAffected == 0) {
                System.out.println("Query not completed");
            } else {
                System.out.println("Query complete, " + rowsAffected + " rows updated.");
            }
            System.out.println("After all changes: ");
            programmer = statement.executeQuery("SELECT * FROM java_programming");
            while (programmer.next()) {
                System.out.println(programmer.getString("id") +" "+ programmer.getString("name") +" "+ programmer.getString("grade"));
            }
            

            statement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
