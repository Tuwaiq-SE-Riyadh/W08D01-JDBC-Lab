package com.company;


import java.sql.*;

public class Main {

    public static <carl> void main(String[] args) {
	// write your code here

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Programmers?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "1234"
            );

            Statement statement = connection.createStatement();
            ResultSet programer;
//            String sql;
            int rowsAffected;



//          sql="CREATE TABLE java_programming ( "
//                  + "id INT not null,"
//                  +"name VARCHAR(255),"+
//                  "grade INT,"+"PRIMARY KEY (id))";

//            statement.execute(sql);
//            rowsAffected =statement.executeUpdate("INSERT INTO java_programming VALUES(55,'carld ives',61)");
//            rowsAffected =statement.executeUpdate("INSERT INTO java_programming VALUES(66,'Dennis Fredric',88)");
//            rowsAffected =statement.executeUpdate("INSERT INTO java_programming VALUES(77,'Jan Rashirdes',78)");

//            programer=statement.executeQuery("SELECT * FROM java_programming WHERE grade BETWEEN 60 and 80");
//
//            while(programer.next()){
//                System.out.println(programer.getInt("id")+" ,"+programer.getString("name")+" ,"+programer.getInt("grade"));
//            }

            rowsAffected =statement.executeUpdate("UPDATE java_programming SET grade=65 WHERE id=55");
           rowsAffected =statement.executeUpdate("DELETE FROM  java_programming WHERE  name='Dennis Fredric'");
            rowsAffected =statement.executeUpdate("UPDATE java_programming SET grade=80 WHERE id>55");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
