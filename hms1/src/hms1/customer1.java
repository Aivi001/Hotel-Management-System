/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms1;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.sql.*;
/**
 *
 * @author ice
 */
public class customer1 {
    public int custId;
    public String custName;
    public String phNo;
    public String address;
    public String rno;
    public ArrayList<food1>fl1=new ArrayList<food1>();
        
    
    customer1()
	{
		custId=1;
		custName="a";
		phNo="9876234567";
		address="Old no.8, SSN Nagar";
		rno="7";
	}
    
      public void addToList(food1 f)
      {
          fl1.add(f);
      }
      
      public String getFname(int i)
	{
		return fl1.get(i).foodName;
	}
      
      
    
};
