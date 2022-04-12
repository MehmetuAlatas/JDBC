package jdbc_preparedstatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class preparedemo {
    public static void main(String[] args) {
        try{
            //loading the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create a database connection
            String url = "jdbc:mysql://localhost:3306/jdbc_tech";
            String username = "root";
            String password = "12345";

            //call a connection driver
            Connection connection = DriverManager.getConnection(url,username,password);

            //if we fail in building the connection
          /*  if(connection.isClosed()){
                System.out.println("Connection is failed or closed");
            }else{
                System.out.println("Connection has been established!");
            } */
            String query = "insert into students(id,name,email,country) values(?,?,?,?)";

            //now we need to make a prepared statements
            PreparedStatement pstment = connection.prepareStatement(query);

            //now enter the students data. you can enter the data as many as you want
            pstment.setInt(1,3);
            pstment.setNString(2,"Omer");
            pstment.setNString(3,"omer@gmail.com");
            pstment.setNString(4,"Turkey");

            pstment.setInt(1,4);
            pstment.setNString(2,"Ahmet");
            pstment.setNString(3,"ahmet@gmail.com");
            pstment.setNString(4,"Turkey");

            pstment.executeUpdate();

            System.out.println("Successfully inserted into DB");
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}