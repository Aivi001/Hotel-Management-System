package hms;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;  


public class HMSservice{
public static void main(String[] argv){

	Room r1=new Room(100,"single");
	Room r2=new Room(103,"single");
	Room r3=new Room(102,"triple");
        Receptionist r=new Receptionist();
        r.add_room(r1);
        r.add_room(r2);
        r.add_room(r3);
	Customer c1=new Customer("aishu","9999999999");
        Customer c2=new Customer("manuu","9999999999");

	r.book_rooms(c1,"single");
        r.book_rooms(c2,"double");
}
};
