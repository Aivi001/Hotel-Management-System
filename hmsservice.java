package hms;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.lang.*;


public class hmsservice{
	   public static void main(String args[]) {  
        System.out.println("Welcome to package");
        customer c=new customer();

        	 try {
	String JDBC_DRIVER ="com.mysql.jdbc.Driver";
	String DB_URL="jdbc:mysql://localhost:3306/hms?useSSL=false";
	String USER = "root";
	String PASS = "root";
	String fName;
	int fidInsert,custId;

         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * from food");
	 
	 while(rs.next()){
             fidInsert=rs.getInt("fid");
             custId=rs.getInt("cid");
             fName=rs.getString("fname");

          	food f=new food(fidInsert,custId,fName);	
         	c.addFood(f);
          	}
          		
          	

         
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) {
         //Handle errors for JDBC
         se.printStackTrace();
     }
     catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      }
        c.orderFood();

    }  
};