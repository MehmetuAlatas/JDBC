package jdbc_user_input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Student {
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

            //if we fail in building the connect
            if(connection.isClosed()){
                System.out.println("Connection is failed or closed");
            }else{
                System.out.println("Connection has been established!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}