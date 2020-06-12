/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.lang.*;
/**
 *
 * @author ice
 */
public class foodOrder {
    public int orderid;
	public int fid;
	public int cid;

	foodOrder()
	{
		orderid=1;
		fid=1;
		cid=1;
	}

	public void foodOrderPopulate(String foodN,int custId)
	{
		 try {
	String JDBC_DRIVER ="com.mysql.jdbc.Driver";
	String DB_URL="jdbc:mysql://localhost:3306/hms?useSSL=false";
	String USER = "root";
	String PASS = "root";
	int fidInsert;

         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * from food where fname='"+foodN+"'");
	 
	 if(rs.next()){
             fidInsert=rs.getInt("fid");
          		System.out.println("Value of fid is "+fidInsert+"\n");
             PreparedStatement pst = conn.prepareStatement("INSERT into foodOrder (fid,cid) values(?,?)");
	 
         pst.setInt(1,fidInsert);   
	 pst.setInt(2,custId);  
	    
          int i = pst.executeUpdate();  
              if(i!=0){  
                System.out.println("Record has been inserted\n");  
                   
           
              }  
              else{  
                System.out.println("Failed to insert the data\n");  
               }  

         // Clean-up environment
         pst.close();
          	}
          	else
          	{
          		System.out.println("No such food\n");
          	}
          		

         // Clean-up environment
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
 }
    
    
}
