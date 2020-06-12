package hms;

import java.util.*;
import java.io.*;
import java.sql.*;

public class customer{

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

	public void orderFood()
	{
		foodOrder f=new foodOrder();
        f.foodOrderPopulate(this.getFname(0),this.id);
	}

	public void addFood(food f)
	{
		fl.add(f);
	}

	public String getFname(int i)
	{
		return fl.get(i).fname;
	}
};