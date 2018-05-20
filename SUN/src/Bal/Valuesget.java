package Bal;

import java.sql.*;

public class Valuesget {
	
	 String sql = null;
	 Connection con = null;
	 Statement statement = null;
	
	Valuesget(String root, String balsun)
	{
    	
	}
	
	//root@localhost:3306
	//jdbc:mysql://localhost:3306/?user=root
	
	//final String driver = "com.mysql.jdbc.Driver";  
	//final String url = "jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	//final String gridurl = "jdbc:mysql://localhost/MicroGrid?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	//String PASS = "balsun";
	//String USER = "root"; 
	//*/
	void method()
	{
	
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	{
	try {
		Class.forName("org.mysql.jdbc.Driver");
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
		.getConnection("jdbc:mysql://localhost:3306/?user=root","root", "balsun");

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
		double[][] NORMmeasurlist= new double [200][18];
		
		double[][] NormMeasurement(double[][] measurlist)
		{
			
	    //////// Normalization ////////////
			// Maximum/Minimum Voltage Value
			for(int k=0; k<200; k++){
				double maxVol=measurlist[k][0];
				double minVol=measurlist[k][0];
				for (int i=0; i<18; i+=2) {
					if (measurlist[k][i] > maxVol) {
			    	maxVol = measurlist[k][i];
			    }
					if (measurlist[k][i] < minVol) {
			    	minVol = measurlist[k][i];
			    }
			}
			for (int i=0; i<18; i+=2) {
				NORMmeasurlist[k][i]=(measurlist[k][i]-minVol)/(maxVol-minVol);
			}
			}
			// Maximum/Minimum Angle Value
			for(int k=0; k<200; k++){
			double maxAng=measurlist[k][1];	
			double minAng=measurlist[k][1];
			for (int i=1; i<18; i+=2) {
			    if (measurlist[k][i] > maxAng) {
			    	maxAng = measurlist[k][i];
			    }
			    if (measurlist[k][i] < minAng) {
			    	minAng = measurlist[k][i];
			    }
			}
			for (int i=1; i<18; i+=2) {
				NORMmeasurlist[k][i]=(measurlist[k][i]-minAng)/(maxAng-minAng);
				}
			}
			return NORMmeasurlist;			
		}
	    
		Connection conn = null;
	    Statement stmt = null;
	    

double[] pointlist= new double [3600];
double[][] measurlist= new double [200][18];
/*
public double[][] pointOfMeasurement() {

    try{
	      // Register JDBC driver
	      Class.forName(driver);
	      
	      // Open a connection
	      System.out.println("Connecting to SQL server...");
	      conn=DriverManager.getConnection(url + gridurl, USER, PASS);

		  // execute a query to create database. It should have the same name as in the MySQL
		  System.out.println("\n"+"Creating database...");
		  stmt = conn.createStatement();
		  conn = DriverManager.getConnection(url + "system9Buses" + gridurl, USER, PASS);
		  sql = "USE system9Buses";
		  stmt.executeUpdate(sql);

		  sql = "SELECT * FROM measurements";
		  ResultSet rs = stmt.executeQuery(sql); // execute query
		  
		  int count=0;
			// Insert values into an ArrayList
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

*/
		
}	
		

	
	

	

