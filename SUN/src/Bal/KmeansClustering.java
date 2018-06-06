package Bal;


import java.util.*;



public class KmeansClustering {
	
	static ArrayList<String> type = new ArrayList<String>();
	
	static ArrayList<String> type1 = new ArrayList<String>();
	static ArrayList<String> type2 = new ArrayList<String>();
	static ArrayList<String> type3 = new ArrayList<String>();
	static ArrayList<String> type4 = new ArrayList<String>();
	
	static double [][] values = new double [150][4];
	static double [][] centroids = new double [4][4];
	
	static double [][] cluster1 = new double [150][4];
	static double [][] cluster2 = new double [150][4];
	static double [][] cluster3 = new double [150][4];
	static double [][] cluster4 = new double [150][4];
	
	static double dist1,dist2,dist3,dist4;
	static int index1,index2,index3,index4;

	
	Random rand = new Random();
	double[][] RandCenter = new double[4][18];
	int[] index = new int[4]; 
	
	public double[][] createRandom(double[][] points){
		for(int i=0; i<4; i++){
				index[i]=rand.nextInt(200);
		}
				for(int j=0; j<4; j++){
					for(int k=0; k<4; k++){
						if (index[j]==index[k] && k!=j){
							index[k]=rand.nextInt(199-0)+0;
						}
					}
				}
				System.out.println("\n"+" ** Forgy Method for Initializing ** ");
				System.out.println("Index of randomly selected points of measurements: "+index[0]+"\t"+index[1]+"\t"+index[2]+"\t"+index[3]+"\n");
				for(int i=0; i<4; i++){
					for(int j=0; j<18; j++){
						RandCenter[i][j]= points[index[i]][j];	
					}
				}
				return RandCenter;
	}
	public double[][] getRandCenter(){
			return RandCenter;
	}
		
/*
public void clustering()
{
	
	do {
		int iteration = 0;
		boolean flag1 = false;
		double[][] LastRandomNormalisedMlistcenters;
		double[][] InitRandomNormalisedMlistcenters;
		
		String US = "root";
		String PW = "balsun";
		
		Valuesget V1 = new Valuesget(US,PW);
		
		
		
		double[][] Mlist = V1.pointOfMeasurement();
		double[][] NormalisedMlist = V1.Measurenormalised(Mlist);
		double[][] RandomNormalisedMlistcenters = getRandCenter();
		
		
		while(!flag1)
		{
			
			
			
			

	
}
	}
}
/*
 * 
 */
}

