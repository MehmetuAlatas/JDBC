package com.company;

import java.sql.*;

public class Main {
    //first we need to write mysql query and store it into any variable
    private static final String QUERY = "select * from students";

    public static void main(String[] args) throws  SQLException {

        //Step 1. Establish the connection of Mysql database
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_tech?useSSL=false","root","12345");

            //step 2: create a statement using that above connection object
            Statement stmt = connection.createStatement();

            //step 3: execute the query. there are 2 methods for executing the query. execute() & executeQuery()
            ResultSet rs = stmt.executeQuery(QUERY)){

            //step 4: process the result and execute it
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                //finally printing my result
                System.out.println(id+ " , "+ name + " , "+ email+" , "+country);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}