package Bal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Valuesget {
	
	 String sql = null;
	 Connection con = null;
	 Statement statement = null;
	
	Valuesget(String root, String balsun)
	{
    	
	}
	
	//root@localhost:3306
	//jdbc:mysql://localhost:3306/?user=root
	
	final String driver = "com.mysql.cj.jdbc.Driver";  
	final String url = "jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	final String gridurl = "jdbc:mysql://localhost/subtables?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	String PASS = "balsun";
	String USER = "root"; 
	
	void meethod()
	{
	
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		
		return;
	}
	}
	System.out.println("MySQL JDBC Driver Registered!");
	
	Connection connection = null;
	{

	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "balsun");

	} catch (SQLException e1) {
		System.out.println("Connection Failed! Check output console");
		e1.printStackTrace();
		return;
	}

	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
	
	}
	}
double[] pointlist= new double [3600];
double[][] measurlist= new double [200][19];
double[][] graphlist1 = new double[2][1800];

//*********************Measurement Table Analysis*********************************//

public double[][] pointOfMeasurement() {

    try{
	      // Register JDBC driver
	      Class.forName(driver);
	      double[][] graphlist = new double[2][1800];

	      // Open a connection
	      System.out.println("Connecting to SQL server...");
	      con=DriverManager.getConnection(url, USER, PASS);

		  // execute a query to create database. It should have the same name as in the MySQL
		  System.out.println("\n"+"Creating database...");
		  statement = con.createStatement();
		  con = DriverManager.getConnection(gridurl , USER, PASS);
		  sql = "USE subtables";
		  statement.executeUpdate(sql);

		  sql = "SELECT * FROM measurements";
		  ResultSet rs = statement.executeQuery(sql); // execute query
		  
		  //sql = "SELECT COUNT(*) FROM measurements";
		  //ResultSet Rows_total = statement.executeQuery(sql);
		  
		 // System.out.println(Rows_total);
		  
		  //double RT = Rows_total.getDouble(sql);
		  
		  statement = con.createStatement();
		  ResultSet r = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM measurements");
		  r.next();
		  int countR = r.getInt("rowcount");
		  r.close();
		  System.out.println("MyTable has " + countR + " row(s).");
		  
		  int count =0;
			while (rs.next()) {	 //false if there are no more rows to take into account
				
				
				Measurement meas=new Measurement(rs.getString("rdfid"), rs.getString("name"),
						         rs.getDouble("time"),rs.getDouble("value"),rs.getString("sub_rdfid"));
				pointlist[count]=meas.getValue();
				count++;
				}
			
			for(int i=0;i<200;i++){
				for(int j=0;j<18 ;j++){
					measurlist[i][j]=pointlist[i*18+j];
				}
			}
			
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<1800;j++) {
					graphlist[i][j]=pointlist[i*1800+j];
				}
			}
		
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<1800;j++) {
					graphlist1[i][j]=graphlist[i][j];
				}
			}
			System.out.println("Database is working");
			
    }catch (SQLException se) {
		// Handle errors for JDBC
		se.printStackTrace();
	} catch (Exception e) {
		// Handle errors for Class.forName
		e.printStackTrace();
	}
  
	return measurlist;
} //Finish Method

double[][] graphlist = new double[2][1800];
double[][] graphnormalist= new double [2][1800];

public double[][] graphdata() {
	try {
	Class.forName(driver);
    

    // Open a connection
    System.out.println("Connecting to SQL server...");
    con=DriverManager.getConnection(url, USER, PASS);

	  // execute a query to create database. It should have the same name as in the MySQL
	  System.out.println("\n"+"Creating database...");
	  statement = con.createStatement();
	  con = DriverManager.getConnection(gridurl , USER, PASS);
	  sql = "USE subtables";
	  statement.executeUpdate(sql);

	  sql = "SELECT * FROM measurements";
	  ResultSet rs = statement.executeQuery(sql); // execute query
	  
	  //sql = "SELECT COUNT(*) FROM measurements";
	  //ResultSet Rows_total = statement.executeQuery(sql);
	  
	 // System.out.println(Rows_total);
	  
	  //double RT = Rows_total.getDouble(sql);
	  
	  statement = con.createStatement();
	  ResultSet r = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM measurements");
	  r.next();
	  int countR = r.getInt("rowcount");
	  r.close();
	  System.out.println("MyTable has " + countR + " row(s).");
	  
	  int count =0;
		while (rs.next()) {	 //false if there are no more rows to take into account
			
			
			Measurement meas=new Measurement(rs.getString("rdfid"), rs.getString("name"),
					         rs.getDouble("time"),rs.getDouble("value"),rs.getString("sub_rdfid"));
			pointlist[count]=meas.getValue();
			count++;
			}
		
		int ui=0, uk=0;
			for(int j=0;j<3600;j++) {
				
				if(j%2!=0)
				{
				graphlist[0][ui]=pointlist[j];
				ui++;
				}
				else
				{
				graphlist[1][uk]=pointlist[j];
				uk++;
				}
			}

		
			for(int j=0;j<1800;j++) {
				graphnormalist[0][j]=(graphlist[0][j])/180;
			}
		
			for(int u=1;u<1800;u++) {
				graphnormalist[1][u]=(graphlist[1][u]);
		
			}
		
}catch (SQLException se) {
	// Handle errors for JDBC
	se.printStackTrace();
} catch (Exception e) {
	// Handle errors for Class.forName
	e.printStackTrace();
}

	return graphlist;
}
/////////////////////////////////////Analog Values//////////////////////////
double[] anagpointlist= new double [3600];
double[][] anaglist= new double [200][19];
public double[][] pointofanalog() {

    try{
	      // Register JDBC driver
	      Class.forName(driver);
	      
	      // Open a connection
	      System.out.println("Connecting to SQL server...");
	      con=DriverManager.getConnection(url, USER, PASS);

		  // execute a query to create database. It should have the same name as in the MySQL
		  System.out.println("\n"+"Creating database...");
		  statement = con.createStatement();
		  con = DriverManager.getConnection(gridurl , USER, PASS);
		  sql = "USE subtables";
		  statement.executeUpdate(sql);

		  sql = "SELECT * FROM analog_values";
		  ResultSet rs = statement.executeQuery(sql); // execute query
		  
		  
		  statement = con.createStatement();
		  ResultSet r = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM analog_values");
		  r.next();
		  int countR = r.getInt("rowcount");
		  r.close();
		  System.out.println("MyTable has " + countR + " row(s).");
		  
		  int count =0;
			while (rs.next()) {	 //false if there are no more rows to take into account
				
				
				Measurement anag=new Measurement(rs.getString("rdfid"), rs.getString("name"),
						         rs.getDouble("time"),rs.getDouble("value"),rs.getString("sub_rdfid"));
				anagpointlist[count]=anag.getValue();
				count++;
				}
			for(int i=0;i<20;i++){
				for(int j=0;j<18 ;j++){
					anaglist[i][j]=anagpointlist[i*18+j];
				}
				anaglist[i][18]=0.0;
			}
		
			System.out.println("Database is working");
			
    }catch (SQLException se) {
		// Handle errors for JDBC
		se.printStackTrace();
	} catch (Exception e) {
		// Handle errors for Class.forName
		e.printStackTrace();
	}
	return anaglist;
} //Finish Method

/////////////////////////////////////////////////////


double[][] Measurenormalist= new double [200][19];
public double[][] Measurenormalised(double[][] measurlist){
	
//////// Normalization ////////////

	
	for(int i=0; i<200; i++){
		for(int j=0;j<18;j+=2) {
			Measurenormalist[i][j]=(measurlist[i][j])/1.1;
		}
	}
	
	for(int i=0; i<200; i++){
		for(int j=1;j<18;j+=2) {
			Measurenormalist[i][j]=(measurlist[i][j])/180;
		}
	}
	
	
	return Measurenormalist;
	
	
	
}

double[][] Measurenormalisttest= new double [20][18];
public double[][] Measurenormalised4test(double[][] measurlist){
	
//////// Normalization ////////////

	
	for(int i=0; i<20; i++){
		for(int j=0;j<18;j+=2) {
			Measurenormalisttest[i][j]=(measurlist[i][j])/1.1;
		}
	}
	
	for(int i=0; i<20; i++){
		for(int j=1;j<18;j+=2) {
			Measurenormalisttest[i][j]=(measurlist[i][j])/180;
		}
	}
	
	
	return Measurenormalisttest;
	
	
	
}


////////DENormalization ////////////
double[][] C_Final_Measurenormalist= new double [4][19];

public double[][] Measuredenormalised(double[][] measurlist, double[][] originallist){
	

	
	
	for(int i=0; i<4; i++){
		for(int j=0;j<19;j+=2) {
			C_Final_Measurenormalist[i][j]=(measurlist[i][j])*1.1;
		}
	}
	
	for(int i=0; i<4; i++){
		for(int j=1;j<19;j+=2) {
			C_Final_Measurenormalist[i][j]=(measurlist[i][j])*180;
		}
	}
				return C_Final_Measurenormalist;
				
	
}



double[][] C_Final_Measurenormalisttest= new double [4][18];

public double[][] Measuredenormalised4test(double[][] measurlist){
	

	
	
	for(int i=0; i<4; i++){
		for(int j=0;j<18;j+=2) {
			C_Final_Measurenormalisttest[i][j]=(measurlist[i][j])*1.1;
		}
	}
	
	for(int i=0; i<4; i++){
		for(int j=1;j<18;j+=2) {
			C_Final_Measurenormalisttest[i][j]=(measurlist[i][j])*180;
		}
	}
				return C_Final_Measurenormalisttest;
				
	
}



}

		
	
	

	

