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

double[][] Measurenormalist= new double [200][18];
public double[][] Measurenormalised(double[][] measurlist){
	
//////// Normalization ////////////
/*
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
		Measurenormalist[i][i1]=(measurlist[i][i1]-minVol)/(maxVol-minVol);
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
		Measurenormalist[i][i1]=(measurlist[i][i1]-minAng)/(maxAng-minAng);
		}
	}
	*/
	//for(int k=0; k<200; k++)
		//for (int i=1; i<18; i=i+2) 
	//System.out.println(Measurenormalist[k][i]);
	
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
/*
public double maxV(double[][] measurlist){
	
////////MaxV ////////////

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

}
return maxVol;
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



return Measurenormalist;



}
*/

////////DENormalization ////////////
double[][] C_Final_Measurenormalist= new double [4][18];

public double[][] Measuredenormalised(double[][] measurlist, double[][] originallist){
	
	/*
	for(int i=0; i<4; i++){
		double maxVol=originallist[i][0];
		double minVol=originallist[i][0];
		for (int j=0; j<18; j=j+2) {
			if (originallist[i][j] > maxVol) {
	    	maxVol = originallist[i][j];
	    }
			if (originallist[i][j] < minVol) {
	    	minVol = originallist[i][j];
	    }
	}
		for (int i1=0; i1<18; i1=i1+2) {
			C_Final_Measurenormalist[i][i1]=(measurlist[i][i1]*(maxVol-minVol))+minVol;
		}
	
	}
	
	// Maximum/Minimum Angle Value
	for(int i=0; i<4; i++){
	double maxAng=originallist[0][1];	
	double minAng=originallist[0][1];
	for (int j=1; j<18; j=j+2) {
	    if (measurlist[i][j] > maxAng) {
	    	maxAng = originallist[i][j];
	    }
	    if (measurlist[i][j] < minAng) {
	    	minAng = originallist[i][j];
	    }
	}
	for (int i1=1; i1<18; i1=i1+2) {
		C_Final_Measurenormalist[i][i1]=(measurlist[i][i1]*(maxAng-minAng))+minAng;
		}
	}
	
	
	for(int i=0; i<4; i++){
		double maxVolcen=measurlist[i][0];
		double minVolcen=measurlist[i][0];
		for (int j=0; j<18; j=j+2) {
			if (measurlist[i][j] > maxVolcen) {
	    	maxVolcen = measurlist[i][j];
	    }
			if (measurlist[i][j] < minVolcen) {
	    	minVolcen = measurlist[i][j];
	    }
	}
		for (int i1=0; i1<18; i1=i1+2) {
			C_Final_Measurenormalist[i][i1]=(measurlist[i][i1]*(maxVol-minVolcen))+minVolcen;
		}
	}
	
	
	
			for(int i=0; i<4; i++){
				double maxAngcen=measurlist[i][1];	
				double minAngcen=measurlist[i][1];
				for (int j=1; j<18; j=j+2) {
				    if (measurlist[i][j] > maxAngcen) {
				    	maxAngcen = measurlist[i][j];
				    }
				    if (measurlist[i][j] < minAngcen) {
				    	minAngcen = measurlist[i][j];
				    }
				}
				for (int i1=1; i1<18; i1=i1+2) {
					C_Final_Measurenormalist[i][i1]=(measurlist[i][i1]*(maxAngcen-minAngcen))+minAngcen;
					}
				}
				
			
				*/
	
	
	
	for(int i=0; i<4; i++){
		for(int j=0;j<18;j+=2) {
			C_Final_Measurenormalist[i][j]=(measurlist[i][j])*1.1;
		}
	}
	
	for(int i=0; i<4; i++){
		for(int j=1;j<18;j+=2) {
			C_Final_Measurenormalist[i][j]=(measurlist[i][j])*180;
		}
	}
				return C_Final_Measurenormalist;
				
	
}

}

		

	
	

	

