/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;


import java.util.*;
import java.io.*;
import java.sql.*;

/**
 *
 * @author ice
 */
public class customer {
    public int id;
	public String name;
	public String phno;
	public String address;
	public int room;
	public ArrayList<food>fl=new ArrayList<food>();

	customer()
	{
		id=1;
		name="a";
		phno="9876234567";
		address="Old no.8, SSN Nagar";
		room=7;
	}

	public void orderFood(String fn)
	{
            
	foodOrder f=new foodOrder();
        f.foodOrderPopulate(fn,this.id);
	}

	public void addFood(food f)
	{
		fl.add(f);
	}

	public String getFname(int i)
	{
		return fl.get(i).fname;
	}
        
        public void getFoodList(String item_name,int c_id)
        {
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
             fidInsert=rs.getInt(1);
             custId=rs.getInt(2);
             fName=rs.getString("fname");

          	food f=new food(fidInsert,custId,fName);	
         	this.addFood(f);
                this.id=c_id;
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
       
        }
    
}
