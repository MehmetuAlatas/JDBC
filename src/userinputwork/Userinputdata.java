package userinputwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;

public class Userinputdata {
    public static void main(String[] args) {
        try{
            //loading the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create a database connection
            String url = "jdbc:mysql://localhost:3306/jdbc_tech";
            String username = "root";
            String password = "techproedu";

            //call a connection driver
            Connection connection = DriverManager.getConnection(url,username,password);

            String query = "insert into studentss(name,email,country) values(?,?,?)";

            //now we need to make a prepared statements
            PreparedStatement pstment = connection.prepareStatement(query);

            //buffer library to take input line by line
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter Your Name: ");
            String name = br.readLine();

            System.out.println("Enter Your Email: ");
            String email = br.readLine();

            System.out.println("Enter Your Country: ");
            String country = br.readLine();

            //now enter the students data. you can enter the data as many as you want

            pstment.setNString(1,name);
            pstment.setNString(2,email);
            pstment.setNString(3,country);


            pstment.executeUpdate();

            System.out.println("Successfully inserted into DB");
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}