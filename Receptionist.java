package hms;

import java.io.*;
import java.sql.*;
import java.util.*; 

public class Receptionist
{
public int rid;
public String rname;
public String phno;
private List<Room> rooms = new ArrayList<Room>();

Receptionist()
{
rid=1;
rname="Sara";
phno="999999999";
}

public void add_room(Room r)
{
    rooms.add(r);
}


private Connection connect_db()
{
    try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms?useSSL=false","root","root");  
       return con;
 }
   catch(Exception e) {
	 e.printStackTrace();
        }   
    return null;
}


public int check_avail(String type)
{
Connection con=connect_db();
int avail=0;
System.out.println("Available rooms:  ");
for(int i=0;i<rooms.size();i++)
    {
    if(type.equals(rooms.get(i).type))
        {   
            avail=1;
            System.out.println(rooms.get(i).rid+" ");
        }
    }
return avail;
}

public int check_alreadybooked(int rno)
{
    Connection con=connect_db();
try{
        Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * from customer where rid="+rno);
        if(rs.next())
	{	
	System.out.println("Room already Booked");
	rs.close();
         stmt.close();
         con.close();
            return 0;
      	}
	} catch(SQLException se) {
          se.printStackTrace();
      }
return 1;
}

public int book_rooms(Customer c,String type)
{
        Connection con=connect_db();
        if(this.check_avail(type)==0)
	{	System.out.println("No rooms of type"+type);
		System.exit(0);
	}
        
        System.out.println("Choose room:");
        Scanner in= new Scanner(System.in);
        int rno= in.nextInt();
        if(check_alreadybooked(rno)!=0)
        {
	try{
        Statement stmt=con.createStatement();  
	 PreparedStatement pst = con.prepareStatement("INSERT into customer(cname,cphone,rid) values(?,?,?)"); 
         pst.setString(1,c.cname);   
	 pst.setString(2,c.phno);  
	 pst.setInt(3,rno);  
          int i = pst.executeUpdate();  
              if(i!=0)
                System.out.println("Room Booked"); 
              else{  
                System.out.println("Failed to Book");  
               }  
         pst.close();
         con.close();
      } catch(SQLException se) {
         System.out.println("Room not Present");
      } 
      }
return 1;
}

};
