package Bal;

public class Assignmentmain 
{
	public static void main(String[] args) 
	{
		String a = "root";
		String b= "balsun";
		Valuesget test1 = new Valuesget(a,b);
		
		((Valuesget) test1).meethod();
		double[][] measurlisto = test1.pointOfMeasurement();
		test1.NormMeasurement(measurlisto);
		
		
		
			
	}


}
