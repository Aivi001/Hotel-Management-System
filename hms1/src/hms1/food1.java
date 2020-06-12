/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms1;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.lang.*;

/**
 *
 * @author ice
 */
public class food1 {
    public int foodId;
    public String foodName;
    public int chefId;
    
    	food1()
	{
		foodId=1;
		chefId=1;
		foodName="Pani puri";
	}

	food1(int foodId,int custId,String foodName)
	{
		this.foodId=foodId;
		this.chefId=custId;
		this.foodName=foodName;
	}
    
};
