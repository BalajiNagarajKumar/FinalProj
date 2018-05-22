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
double[][] measurlist= new double [200][18];

//*********************Measurement Table Analysis*********************************//

public double[][] pointOfMeasurement() {

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

		  sql = "SELECT * FROM measurements";
		  ResultSet rs = statement.executeQuery(sql); // execute query
		  
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
			for(int i=0;i<200;i++){
				for(int j=0;j<18 ;j++){
					//System.out.println(i);
					//System.out.println(j);
					//System.out.println((i+1)*(j+1));
					//System.out.println(measurlist[i][j]+" ");
				}
				 //System.out.print("\n");
			}

    }catch (SQLException se) {
		// Handle errors for JDBC
		se.printStackTrace();
	} catch (Exception e) {
		// Handle errors for Class.forName
		e.printStackTrace();
	}
	return measurlist;
} //Finish Method

double[][] NORMmeasurlist= new double [200][18];
public double[][] NormMeasurement(double[][] measurlist){
	
//////// Normalization ////////////

	for(int i=0; i<200; i++){
		double maxVol=measurlist[i][0];
		double minVol=measurlist[i][0];
		for (int j=0; j<18; j=j+2) {
			if (measurlist[i][j] > maxVol) {
	    	maxVol = measurlist[i][j];
	    }
			if (measurlist[i][j] < minVol) {
	    	minVol = measurlist[i][j];
	    }
	}
	for (int i1=0; i1<18; i1=i1+2) {
		NORMmeasurlist[i][i1]=(measurlist[i][i1]-minVol)/(maxVol-minVol);
	}
	}
	
	// Maximum/Minimum Angle Value
	for(int i=0; i<200; i++){
	double maxAng=measurlist[i][1];	
	double minAng=measurlist[i][1];
	for (int j=1; j<18; j=j+2) {
	    if (measurlist[i][j] > maxAng) {
	    	maxAng = measurlist[i][j];
	    }
	    if (measurlist[i][j] < minAng) {
	    	minAng = measurlist[i][j];
	    }
	}
	for (int i1=1; i1<18; i1=i1+2) {
		NORMmeasurlist[i][i1]=(measurlist[i][i1]-minAng)/(maxAng-minAng);
		}
	}
	for(int k=0; k<200; k++)
		for (int i=1; i<18; i=i+1) 
	System.out.println(NORMmeasurlist[k][i]);
	return NORMmeasurlist;
	
	
}

//*********************Analog Values Table Analysis*********************************//




}

		

	
	

	

