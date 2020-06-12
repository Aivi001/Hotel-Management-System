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
public class food {

	public int fid;
	public int cid; //chefId
	public String fname;

	food()
	{
		fid=1;
		cid=1;
		fname="Pani puri";
	}

	food(int foodId,int custId,String foodName)
	{
		this.fid=foodId;
		this.cid=custId;
		this.fname=foodName;
	}


};

