package com.company;
import java.sql.* ;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "password"
            );

            Statement statement = connection.createStatement();
            ResultSet results;
            int rowAffected;


            results = statement.executeQuery("SELECT * FROM java_programming WHERE grade BETWEEN 60 AND 80 ");
            while (results.next()){
                System.out.println(results.getString("id")+"      "+ results.getString("name")+"      "+results.getString("grade"));
            }

            Scanner input = new Scanner(System.in);
//            System.out.println("Enter Name: ");
//            String name = input.nextLine();
//
//            System.out.println("Enter ID: ");
//            int id = input.nextInt();
//
            System.out.println("Enter Grade: ");
            int grade = input.nextInt();
//            statement.executeUpdate("INSERT INTO java_programming VALUES ('"+id+"','"+ name+"','" +grade+"')");
//            -------------------------------------------------------------------------------------------
//            String update = "UPDATE java_programming set grade ="+grade+" WHERE name ='Carl Davis'";
//            statement.executeUpdate(update);
//            -------------------------------------------------------------------------------------------
//            String deleteRow = "delete from java_programming where name = 'Dennis Fredrickson'";
//            statement.executeUpdate(deleteRow);
//            -------------------------------------------------------------------------------------------
            String update = "UPDATE java_programming set grade ="+grade+" WHERE id> 55 AND id<80";
            statement.executeUpdate(update);


            statement.close();
            connection.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
