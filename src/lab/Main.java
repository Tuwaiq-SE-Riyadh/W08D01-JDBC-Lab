package lab;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;
public class Main {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "1234"
            );


            Statement statement1 = connection.createStatement();
            ResultSet programmersTest;
            int rowsAffected;

            // task 1
//            rowsAffected = statement1.executeUpdate("INSERT INTO java_programming (id,name,grade) VALUES (55, 'Carl Davis' ,61),(66, 'Dennis Fredrickson' ,88),(77, 'Jane Richards' ,78)");
//
//            if(rowsAffected > 0)
//            {
//                System.out.println("Add " + rowsAffected +" rows");
//            }
//            else
//            {
//                System.out.println("No changes !!!");
//            }


            // task 2
//            programmersTest = statement1.executeQuery("SELECT * FROM java_programming WHERE grade BETWEEN 60 AND 80");
//            while(programmersTest.next())
//            {
//                System.out.println("Name: " + programmersTest.getString("name") +" | grade: "+ programmersTest.getInt("grade"));
//            }



            // task 3
//            rowsAffected = statement1.executeUpdate("UPDATE java_programming SET grade = 65 WHERE name='Carl Davis' ");
//            if(rowsAffected > 0)
//            {
//                System.out.println("Update " + rowsAffected +" rows");
//            }
//            else
//            {
//                System.out.println("No changes !!!");
//            }

            // task 4
//            rowsAffected = statement1.executeUpdate("DELETE FROM java_programming WHERE name = 'Dennis Fredrickson' ");
//            if (rowsAffected > 0) {
//                System.out.println("DELETE "+rowsAffected + " Rows");
//            } else {
//                System.out.println("No changes !!!");
//            }

            // task 5
//            rowsAffected = statement1.executeUpdate("UPDATE java_programming SET grade = 80 WHERE id > 55 ");
//            if (rowsAffected > 0) {
//                System.out.println("Update "+rowsAffected + " Rows");
//            } else {
//                System.out.println("No changes !!!");
//            }




//            programmersTest.close();
            statement1.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
