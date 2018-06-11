package Bal;


import java.util.*;



public class KmeansClustering {
	
	public double[][] cluster1save = new double[100][100];
	public double[][] cluster2save = new double[100][100];

	public double[][] cluster3save = new double[100][100];

	public double[][] cluster4save = new double[100][100];


	
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
							index[k]=rand.nextInt(4-0)+0;
						}
					}
				}
				System.out.println("Random Initialization\n");
				for(int i=0; i<4; i++){
					for(int j=0; j<18; j++){
						RandCenter[i][j]= points[index[i]][j];	
					}
				}
				
				
				for(int i=0; i<4; i++){
					for(int j=0; j<18; j++){
						System.out.print(RandCenter[i][j]);	
					}
					System.out.println("");
				}
				return RandCenter;
	}
	public double[][] getRandCenter(){
			return RandCenter;
	}
	
	//int counton = 0;
	int counttw = 0;
	int countth = 0;
	int countfo = 0;

	
	public double[][] distance(double[][] datapoints, double[][] centerpoints){
		int counton = 0;
		
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
		double tol = 0.000000001;
		
		double[][] error = new double[4][18];
		
		
		
		
		for(int p=0; p<20000000; p++) {
			
			 double[] clusters = new double[200];

			
		
			counterone = 0; countertwo= 0; counterthree= 0; counterfour= 0;
			int[] a = new int[200]; int b[] = null; int c[] = null;int d[]=null;
			
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
			//clusters[i][1]=i;
			//clusters[i][2]=mindist;
			if(mindist == sdist1) {
				
				clusters[i] = 1;
				//
				//a[i]=i;
				counterone++;
				
				}		
			else if(mindist == sdist2) {
				
				clusters[i] = 2;
				//b[i]=i;
				//System.out.println(i);

				countertwo++;
				
				}
			else if(mindist == sdist3) {
				
				clusters[i] = 3;
				//c[i]=i;


				counterthree++;
				
				}
			else if(mindist == sdist4) {
				
				clusters[i] = 4;
				//System.out.println(i);
				//d[i]=i;

				counterfour++;
				}
			datapoints[i][18]=clusters[i];
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
        		 //cluster1save[j]=datapoints [i][j];
        		 
        		 
    	 }
    		 
    		 if(clusters[i] == 2) {
        		 clustertwodata [j] += datapoints[i][j];
        		 //cluster2save[j]=datapoints [i][j];

    	 }
    	
    		 if(clusters[i] == 3) {
        		 clusterthreedata [j] += datapoints[i][j];
        		 //cluster3save[j]=datapoints [i][j];

    	 }
    		 
    		 if(clusters[i] == 4) {
        		 clusterfourdata [j] += datapoints[i][j];
        		 //cluster4save[j]=datapoints [i][j];

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
	  
		if(esdist1 < tol && esdist2 < tol && esdist3 < tol && esdist4 < tol) {
			
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
		
		counton = counterone;
		
		
		System.out.println(counterone);
		System.out.println(countertwo);

		System.out.println(counterthree);

		System.out.println(counterfour);

		
		return newcenter;
		}

		

	
	
	
	
	
	
	

	public double[] count(double[][] datapoints, double[][] centerpoints){
		int counton = 0;
		
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
		double tol = 0.000000001;
		
		double[][] error = new double[4][18];
		
		
		
		
		for(int p=0; p<20000000; p++) {
			
			
			
			double[] clusters = new double[200];

			counterone = 0; countertwo= 0; counterthree= 0; counterfour= 0;
			int[] a = new int[200]; int b[] = null; int c[] = null;int d[]=null;
			
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
			//clusters[i][1]=i;
			//clusters[i][2]=mindist;
			if(mindist == sdist1) {
				
				clusters[i] = 1;
				//
				//a[i]=i;
				counterone++;
				
				}		
			else if(mindist == sdist2) {
				
				clusters[i] = 2;
				//b[i]=i;
				//System.out.println(i);

				countertwo++;
				
				}
			else if(mindist == sdist3) {
				
				clusters[i] = 3;
				//c[i]=i;


				counterthree++;
				
				}
			else if(mindist == sdist4) {
				
				clusters[i] = 4;
				//System.out.println(i);
				//d[i]=i;

				counterfour++;
				}
			datapoints[i][18]=clusters[i];
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
        		 //cluster1save[j]=datapoints [i][j];
        		 
        		 
    	 }
    		 
    		 if(clusters[i] == 2) {
        		 clustertwodata [j] += datapoints[i][j];
        		 //cluster2save[j]=datapoints [i][j];

    	 }
    	
    		 if(clusters[i] == 3) {
        		 clusterthreedata [j] += datapoints[i][j];
        		 //cluster3save[j]=datapoints [i][j];

    	 }
    		 
    		 if(clusters[i] == 4) {
        		 clusterfourdata [j] += datapoints[i][j];
        		 //cluster4save[j]=datapoints [i][j];

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
	  
		if(esdist1 < tol && esdist2 < tol && esdist3 < tol && esdist4 < tol) {
			
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
		
		counton = counterone;
		
		
	
		
		double[] count = new double[4];
		
		count[0]=counterone;
		count[1]=countertwo;
		count[2]=counterthree;
		count[3]=counterfour;

		
	
			return count;
		
		}

	
	
	

	

	public double[] clusters(double[][] datapoints, double[][] centerpoints){
		int counton = 0;
		
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
		double tol = 0.000000001;
		
		double[][] error = new double[4][18];
		
		double[] clusters = new double[200];

		
		
		for(int p=0; p<20000000; p++) {
			
			for(int n = 0; n<200; n++) { clusters[n]=0;}
			

			counterone = 0; countertwo= 0; counterthree= 0; counterfour= 0;
			int[] a = new int[200]; int b[] = null; int c[] = null;int d[]=null;
			
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
				//System.out.println(i);
				//d[i]=i;

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
        		 //cluster1save[j]=datapoints [i][j];
        		 
        		 
    	 }
    		 
    		 if(clusters[i] == 2) {
        		 clustertwodata [j] += datapoints[i][j];
        		 //cluster2save[j]=datapoints [i][j];

    	 }
    	
    		 if(clusters[i] == 3) {
        		 clusterthreedata [j] += datapoints[i][j];
        		 //cluster3save[j]=datapoints [i][j];

    	 }
    		 
    		 if(clusters[i] == 4) {
        		 clusterfourdata [j] += datapoints[i][j];
        		 //cluster4save[j]=datapoints [i][j];

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
	  
		if(esdist1 < tol && esdist2 < tol && esdist3 < tol && esdist4 < tol) {
			
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
			
		//double[] clustery = new double[200];
		
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		for (int i=0; i<200; i++) {
   			System.out.print(clusters[i]+": ");
   			for(int h=0;h<18;h++)
   			{
   				System.out.print(datapoints[i][h]+ ", ");
   			}
   			System.out.println();
   			

   	}
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

	
			return clusters;
		
		}

	
	
	
	
	
	
	
//public double[] cluster1_label()
//{
	
	//		return clusters;
		
	//}





}