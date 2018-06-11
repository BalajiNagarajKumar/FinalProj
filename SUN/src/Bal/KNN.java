package Bal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class KNN {

	double[][] sdist =new double[200][20];
	double[][] ndist =new double[200][20];
	double[][] mdist =new double[200][20];


	

public double[][] algorithm(double[][] datapoints, double[][] testpoints){
		
	double sdist2 =0;
	double sdist3 =0;
	double sdist4 =0;
	double mindist =0;
	
		for(int i=0; i<20;i++) {
		
			for(int j=0;j<200;j++) {
				double dist =0;
				double dist2 =0;
				double dist3 =0;
				double dist4 =0;
				
				
				for(int k=0;k<18;k++) {
					
					dist += ((datapoints[j][k]-testpoints[i][k])*(datapoints[j][k]-testpoints[i][k]));

				}
				sdist[j][i] = Math.sqrt(dist);
			}
		}
		
		System.out.println("Printing the test points ");

		for(int i=0; i<20;i++) {
			for(int k=0;k<18;k++) {
				System.out.print(testpoints[i][k]+", ");
			}
			
			System.out.println();
		}

		

		ndist = transpose(sdist);

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		

		return sdist;
}
		

public double[][] transpose (double[][] sdist2) {
	  if (sdist2 == null || sdist2.length == 0)//empty or unset array, nothing do to here
	    return sdist2;

	  int width = sdist2.length;
	  int height = sdist2[0].length;

	  double [][] array_new = new double[height][width];

	  for (int x = 0; x < width; x++) {
	    for (int y = 0; y < height; y++) {
	      array_new[y][x] = sdist2[x][y];
	    }
	  }
	  return array_new;
	}

		
}

