package Bal;


import java.util.*;



public class KmeansClustering {
	
	
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
				System.out.println("\n"+" * Forgy Method for Initializing * ");
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
	
	public double[][] distance(double[][] datapoints, double[][] centerpoints){
		
		double[] clusters = new double[200];
		double[][] newcenter = new double [4][18];
		double[][] oldcenter = new double [4][18];

		
		for(int i=0;i<4;i++)
			for(int j=0;j<18;j++)
			{
				newcenter[i][j]= centerpoints[i][j];
			}
		
		for(int i=0;i<4;i++)
			for(int j=0;j<18;j++)
			{
				oldcenter[i][j]= 0;
			}
		
		int counterone=0; 
		int countertwo=0;
		int counterthree=0;
		int counterfour=0;
		double tol = 0.00000001;
		
		double[][] error = new double[4][18];
		
		
		
		
		
		for(int p=0; p<20000000; p++) {
			
			
			
		
			counterone = 0; countertwo= 0; counterthree= 0; counterfour= 0;

		for(int i=0;i<200;i++) {
			
			double dist1 =0;
			double dist2 =0;
			double dist3 =0;
			double dist4 =0;
			double sdist1 =0;
			double sdist2 =0;
			double sdist3 =0;
			double sdist4 =0;
			double mindist =0;
			
			for(int j=0;j<18;j++) {
				
				dist1 += ((newcenter[0][j]-datapoints[i][j])*(newcenter[0][j]-datapoints[i][j]));
				dist2 += ((newcenter[1][j]-datapoints[i][j])*(newcenter[1][j]-datapoints[i][j]));
				dist3 += ((newcenter[2][j]-datapoints[i][j])*(newcenter[2][j]-datapoints[i][j]));
				dist4 += ((newcenter[3][j]-datapoints[i][j])*(newcenter[3][j]-datapoints[i][j]));
				
		}
			sdist1 = Math.sqrt(dist1);
			sdist2 = Math.sqrt(dist2);
			sdist3 = Math.sqrt(dist3);
			sdist4 = Math.sqrt(dist4);
			
			mindist = Math.min(sdist1, Math.min(sdist2, Math.min(sdist3,sdist4)));
			
			if(mindist == sdist1) {
				
				clusters[i] = 1;
				counterone++;
				
				}		
			else if(mindist == sdist2) {
				
				clusters[i] = 2;
				countertwo++;
				
				}
			else if(mindist == sdist3) {
				
				clusters[i] = 3;
				counterthree++;
				
				}
			else if(mindist == sdist4) {
				
				clusters[i] = 4;
				counterfour++;
				}
			
			}
		
		
		
		
		double[] clusteronedata = new double[18];
		double[] clustertwodata = new double[18];
		double[] clusterthreedata = new double[18];
		double[] clusterfourdata =  new double[18];
		double[] avclusteronedata = new double[18];
		double[] avclustertwodata = new double[18];
		double[] avclusterthreedata = new double[18];
		double[] avclusterfourdata =  new double[18];
		
     for(int i = 0; i < 200; i ++){
    	 for (int j=0;j<18;j++) {
    		 
    		 if(clusters[i] == 1) {
        		 clusteronedata [j] += datapoints[i][j];
        		 
    	 }
    		 
    		 if(clusters[i] == 2) {
        		 clustertwodata [j] += datapoints[i][j];
    	 }
    	
    		 if(clusters[i] == 3) {
        		 clusterthreedata [j] += datapoints[i][j];
    	 }
    		 
    		 if(clusters[i] == 4) {
        		 clusterfourdata [j] += datapoints[i][j];
    	 }
    		 
    	 }
     }
     
     
     
     for(int i = 0; i < 18; i ++) {
    	 avclusteronedata[i] = clusteronedata [i] / counterone;
     }
     for(int i = 0; i < 18; i ++) {
    	 avclustertwodata[i] = clustertwodata [i] / countertwo;
     }     
     for(int i = 0; i < 18; i ++) {
    	 avclusterthreedata[i] = clusterthreedata [i] / counterthree;
     }     
     for(int i = 0; i < 18; i ++) {
    	 avclusterfourdata[i] = clusterfourdata [i] / counterfour;
     }
     
     
	 for (int j=0;j<18;j++) {
	 	 oldcenter[0][j]=avclusteronedata[j];
		 oldcenter[1][j]=avclustertwodata[j];
		 oldcenter[2][j]=avclusterthreedata[j];
		 oldcenter[3][j]=avclusterfourdata[j];
	 }
     
		double edist1 =0;
		double edist2 =0;
		double edist3 =0;
		double edist4 =0;
		
		double esdist1 =0;
		double esdist2 =0;
		double esdist3 =0;
		double esdist4 =0;
	 
	 for(int j=0;j<18;j++) {
			
			edist1 += ((newcenter[0][j]-oldcenter[0][j])*(newcenter[0][j]-oldcenter[0][j]));
			edist2 += ((newcenter[1][j]-oldcenter[1][j])*(newcenter[1][j]-oldcenter[1][j]));
			edist3 += ((newcenter[2][j]-oldcenter[2][j])*(newcenter[2][j]-oldcenter[2][j]));
			edist4 += ((newcenter[3][j]-oldcenter[3][j])*(newcenter[3][j]-oldcenter[3][j]));
			
	}
		esdist1 = Math.sqrt(edist1);
		esdist2 = Math.sqrt(edist2);
		esdist3 = Math.sqrt(edist3);
		esdist4 = Math.sqrt(edist4);
	  
		if(esdist1 < tol && esdist2 < tol && esdist2 < tol && esdist2 < tol) {
			
	    	 for (int j=0;j<18;j++) {
	    		 newcenter[0][j]=avclusteronedata[j];
	    		 newcenter[1][j]=avclustertwodata[j];
	    		 newcenter[2][j]=avclusterthreedata[j];
	    		 newcenter[3][j]=avclusterfourdata[j];
	    	 }
	    	 
	    	 break;
	    	 
		}
		
   	 for (int j=0;j<18;j++) {
		 newcenter[0][j]=avclusteronedata[j];
		 newcenter[1][j]=avclustertwodata[j];
		 newcenter[2][j]=avclusterthreedata[j];
		 newcenter[3][j]=avclusterfourdata[j];
	 }
		

    	 
    	 
     }
		
		
		System.out.println(counterone);
		System.out.println(countertwo);

		System.out.println(counterthree);

		System.out.println(counterfour);

		
		return newcenter;
		}

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