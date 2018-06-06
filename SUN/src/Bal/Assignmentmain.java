package Bal;

public class Assignmentmain 
{
	public static void main(String[] args) 
	{
		String a = "root";
		String b= "balsun";
		Valuesget test1 = new Valuesget(a,b);
		KmeansClustering Kmean = new KmeansClustering();
		
		((Valuesget) test1).meethod();
		double[][] measurlisto = test1.pointOfMeasurement();
		double[][] normameasurlisto = test1.Measurenormalised(measurlisto);
		
		//for(int k=0; k<200; k++)
			//for (int i=1; i<18; i=i+2) 
		//System.out.println(normameasurlisto[k][i]);
		
		double[][] Kmeancenter = Kmean.createRandom(normameasurlisto);
		double[][] clustermain = Kmean.distance(normameasurlisto, Kmeancenter );
		for(int i=0; i<4; i++){
			for(int j=0; j<18; j++){
				System.out.println(Kmeancenter[i][j]);
				
			}
			System.out.println();
	}
		
		for(int i=0; i<4; i++){
			for(int j=0; j<18; j++){
				System.out.println(clustermain[i][j]);
				
			}
			System.out.println("new cluster centroid"+i);
	}
		
		double[][] denormameasurlisto = test1.Measuredenormalised(clustermain,Kmeancenter);

		for(int k=0; k<4; k++) {
		for (int i=0; i<18; i++) {
				System.out.println(denormameasurlisto[k][i]);
		}
		System.out.println("Fad");
		}
		
		

}
}