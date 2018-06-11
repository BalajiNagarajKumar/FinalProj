package Bal;
import java.util.Arrays;
import java.util.Comparator;
public class Testsort {
    
	/*
	private static void printTable(String caption, Integer[] orderArray, 
                Integer[] arrayToBeSorted, Integer[] sortOrder){

        System.out.println(caption+
                "\nNo   Num   Color"+
                "\n----------------");

        for(int i=0;i<sortOrder.length;i++){
            System.out.printf("%x    %d     %d\n", 
                    i,orderArray[sortOrder[i]],arrayToBeSorted[sortOrder[i]]);

        }
        
        for(int i=0; i<sortOrder.length; i++){
            System.out.println("SortOrder:"+sortOrder[i]);
        }
    }
*/
	
		//for (int i=0; i<200; i++) {
   			//for(int j=0; j<20;j++) {
   				//System.out.println(orderArray1[i][j]);
   			//}

   //	}
		
		/*
		for(int row=0;row<200;row++)
			//for (int col=0;col<20;col++)
			{
			testarray[row] = orderArray1[row][0];
			}
		
		for(int row=0;row<200;row++)
			
			{
			Arrays.sort( testarray );		
			}
		
		*/
		
		/*
		double[] testarrayy0 = new double [200];
		double[] arrayy0 = new double [200];

		
		double[] testarrayy1 = new double [200];
		double[] testarrayy2= new double [200];
		double[] testarrayy3= new double [200];
		double[] testarrayy4 = new double [200];
		double[] testarrayy5 = new double [200];
		double[] testarrayy6 = new double [200];
		double[] testarrayy7 = new double [200];
		double[] testarrayy8 = new double [200];
		double[] testarrayy9 = new double [200];
		double[] testarrayy10 = new double [200];
		double[] testarrayy11 = new double [200];
		double[] testarrayy12 = new double [200];
		double[] testarrayy13 = new double [200];
		double[] testarrayy14 = new double [200];
		double[] testarrayy15 = new double [200];
		double[] testarrayy16 = new double [200];
		double[] testarrayy17 = new double [200];
		double[] testarrayy18 = new double [200];
		double[] testarrayy19 = new double [200];
		
		for(int j=0; j<200;j++) {
				 testarrayy0[j] =orderArray1[j][0];

			}
		/*for (int i=0; i<200; i++) {
			  
   			System.out.println(testarrayy0[i]);
   			
   	}
		
		
		for (int i = 0; i < 200; i++) {
			Arrays.sort( testarrayy0 );			
			}
			
			for(int i=0; i<200;i++)
			{
				for(int j=0; j<200;j++)
				{
				if(testarrayy0[i]==orderArray1[j][0])
				{
					arrayy0[i]=arrayToBeSorted1[j];
				}
					
			}
			}	
			*/
			/*
			
			System.out.println("!@#$@#%#$%#%^$%$&$&%^&%^&#%^$%@$%#%&%^*&%*");

		for (int i=0; i<200; i++) {
			  
   			System.out.println(testarrayy0[i]);
   			System.out.println( arrayy0[i]);

   	}
		System.out.println("!@#$@#%#$%#%^$%$&$&%^&%^&#%^$%@$%#%&%^*&%*");

		*/
			/*
   			for(int j=0; j<200;j++) {
   				 testarrayy1[j] =orderArray1[j][1];
   			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy1[j] =orderArray1[j][1];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy2[j] =orderArray1[j][2];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy3[j] =orderArray1[j][3];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy4[j] =orderArray1[j][4];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy5[j] =orderArray1[j][5];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy6[j] =orderArray1[j][6];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy7[j] =orderArray1[j][7];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy8[j] =orderArray1[j][8];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy9[j] =orderArray1[j][9];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy11[j] =orderArray1[j][11];
  			}
		
   			for(int j=0; j<200;j++) {
  				 testarrayy12[j] =orderArray1[j][12];
  			}
		

   			for(int j=0; j<200;j++) {
  				 testarrayy13[j] =orderArray1[j][13];
  			}

   			for(int j=0; j<200;j++) {
  				 testarrayy14[j] =orderArray1[j][14];
  			}

   			for(int j=0; j<200;j++) {
  				 testarrayy15[j] =orderArray1[j][15];
  			}

   			for(int j=0; j<200;j++) {
  				 testarrayy16[j] =orderArray1[j][16];
  			}

   			for(int j=0; j<200;j++) {
  				 testarrayy17[j] =orderArray1[j][17];
  			}

   			for(int j=0; j<200;j++) {
  				 testarrayy18[j] =orderArray1[j][18];
  			}

   			for(int j=0; j<200;j++) {
  				 testarrayy19[j] =orderArray1[j][19];
  			}
   			
   			
   			
   			*/
	static int cout1 =0; 
	static int cout2 =0; 

	static int cout3 =0; 

	static int cout4 =0; 
	double[][] printTable(double[][] orderArray1,double[] arrayToBeSorted1){
		double[] testarray = new double [200];
		double[] temparray = new double [200];
		double[] testarray1 = new double [200];
		double[] temparray1 = new double [200];
		double[][] tarray = new double [2][200];
		
		 int couty1 =0; 
		 int couty2 =0; 

		 int couty3 =0; 

		 int couty4 =0;
		
		for (int in = 0; in < 20; in++) {
		for (int i = 0; i < 200; i++) {
		
				
	              testarray[i] = orderArray1[i][in];
	              testarray1[i]= arrayToBeSorted1[i];
	              temparray[i] = orderArray1[i][in];
	              temparray1[i]= arrayToBeSorted1[i];

	            }
	
		for (int i = 0; i < testarray.length; i++) {
			Arrays.sort( testarray );			
			}
		
		for(int i=0; i<testarray.length;i++)
		{
			for(int j=0; j<testarray1.length;j++)
			{
			if(testarray[i]==temparray[j])
			{
				testarray1[i]=temparray1[j];
			}
				
		}
		}

			for(int j =0; j<3; j++)
			{
				System.out.print(testarray[j]+", ");
				System.out.print(testarray1[j]);
				System.out.println();
		

				
			}
			
			System.out.println();
			System.out.println();

			
			for(int j =0; j<1; j++)
			{
				System.out.print("This Test Data "+in +" belongs to cluster ");
				
				
				System.out.print(testarray1[j]);
				System.out.println();

				System.out.print("With the minimum distance being ");

				System.out.print(testarray[j]+", ");
				System.out.println();
				
				if (testarray1[j]==1)
				{
					couty1++;
				}
				else if (testarray1[j]==2)
				{
					couty2++;

				}
				else if (testarray1[j]==3)
				{
					couty3++;

				}else if (testarray1[j]==4)
				{
					couty4++;

				}
				
			}
			System.out.println();
			System.out.println();

			
				for(int j=0; j<200;j++)
				{
					tarray[0][j]=testarray[j];
					tarray[1][j]=testarray1[j];
				}
					
		}
		
		System.out.println("Number of Test Data in Cluster 1   " +couty1);
		System.out.println("Number of Test Data in Cluster 2   " +couty2);

		System.out.println("Number of Test Data in Cluster 3   " +couty3);
		System.out.println("Number of Test Data in Cluster 4   " +couty4);
		
		cout1=couty1;
		cout2=couty2;
		cout3=couty3;
		cout4=couty4;
		
		
		
		return tarray;
	          }
	
	int[] countvangiko(){
		
		int count[]=new int[4];
		count[0]=cout1;
		count[1]=cout2;

		count[2]=cout3;

		count[3]=cout4;
		
		return count;

		
		
	}


}