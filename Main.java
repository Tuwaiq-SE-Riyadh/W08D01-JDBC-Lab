package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Programmers", "root", "1122");
                    Statement statement = con.createStatement();

/*  Insert the following 3 new rows into the java_programming table:

                statement.executeUpdate("INSERT INTO `java_programming` (`id`, `name`, `grade`) VALUES ('55', 'Carl Davis', '61');");
                statement.executeUpdate("INSERT INTO `java_programming` (`id`, `name`, `grade`) VALUES ('66', 'Dennis Fredrickson', '88');");
                statement.executeUpdate("INSERT INTO `java_programming` (`id`, `name`, `grade`) VALUES ('77', 'Jane Richards', '78');");
*/

                    ResultSet res = statement.executeQuery("SELECT * FROM java_programming WHERE grade between 60 AND 80");
                    System.out.println("-----------------------Select all records with a grade between 60 and 80-------------------------");
                    while (res.next()) {
                        System.out.println("ID: "+res.getInt(1)+" Name:("+res.getString(2)+") Grade:"+res.getInt(3));
                    }



                    statement.executeUpdate("UPDATE java_programming SET grade = 65 WHERE name = 'Carl Davis'");
                    res= statement.executeQuery("SELECT * FROM java_programming;");

                    System.out.println("-----------------------Change Carl Davis’s grade to 65-------------------------");
                    while (res.next()) {
                        System.out.println("ID: "+res.getInt(1)+" Name:("+res.getString(2)+") Grade:"+res.getInt(3));
                    }


                    statement.executeUpdate("DELETE FROM java_programming WHERE name = 'Dennis Fredrickson'");
                    res= statement.executeQuery("SELECT * FROM java_programming;");
                    System.out.println("-----------------------Delete Dennis Fredrickson’s row-------------------------");
                    while (res.next()) {
                        System.out.println("ID: "+res.getInt(1)+" Name:("+res.getString(2)+") Grade:"+res.getInt(3));
                    }


                    statement.executeUpdate("UPDATE java_programming SET grade = 100 WHERE id > 55 AND id <= 80");
                    res= statement.executeQuery("SELECT * FROM java_programming;");
                    System.out.println("-----------------------Change the grade of all people with an id greater than 55 to 80-------------------------");
                    while (res.next()) {
                        System.out.println("ID: "+res.getInt(1)+" Name:("+res.getString(2)+") Grade:"+res.getInt(3));
                    }


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

        }
