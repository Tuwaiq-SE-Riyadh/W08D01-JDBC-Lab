import java.sql.*;
public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "Admin"
            );
            Statement statement = connection.createStatement();
//            statement.executeUpdate("INSERT INTO java_programming(id, name, grade) values (55, 'Carl Davis', 61), (66, 'Dennis Fredrickson', 88),(77, 'Jane Richards', 78);");

//          Select all records with a grade between 60 and 80.
            ResultSet results = statement.executeQuery("SELECT * from java_programming where grade BETWEEN 60 and 80;");
            while (results.next()){
                System.out.println(results.getInt("id") + ", "
                        +results.getString("name")
                        + ", "+results.getString("grade"));
            }
////          Change Carl Davis’s grade to 65.
            statement.executeUpdate("UPDATE java_programming SET grade=65 WHERE name='Carl Davis'");

////          Delete Dennis Fredrickson’s row.
            statement.executeUpdate("DELETE FROM java_programming WHERE name='Dennis Fredrickson';");

//          Change the grade of all people with an id greater than 55 to 80.
            statement.executeUpdate("UPDATE java_programming SET grade=10 WHERE id>55 and id <80;");
            ResultSet results2 = statement.executeQuery("SELECT * from java_programming;");
            while (results2.next()){
                System.out.println(results2.getInt("id") + ", "
                        +results2.getString("name")
                        + ", "+results2.getString("grade"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}