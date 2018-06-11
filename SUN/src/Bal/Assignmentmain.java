package Bal;

import java.awt.*;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



import java.util.HashSet;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;

public class Assignmentmain 
{
	
	static double[] county = new double[4];
	static double[][] normameasurlisto = new double[200][18];
	static double[][] knnlist =new double[200][20];
	static double[][] Kmeancenter = new double[4][18];
	static double[][] sorted = new double[2][200];
	static double[][] measurlisto = new double[200][18];
	@SuppressWarnings("deprecation")
	public static void amain() 
	{
		String a = "root";
		String b= "balsun";
		Valuesget test1 = new Valuesget(a,b);
		KmeansClustering Kmean = new KmeansClustering();
		
		((Valuesget) test1).meethod();
		 measurlisto = test1.pointOfMeasurement();
		//normameasurlisto = test1.Measurenormalised(measurlisto);
		double[] cluster = new double[200];
		
		
	
	
			
		Kmeancenter = Kmean.createRandom(measurlisto);
		double[][] clustermain = Kmean.distance(measurlisto, Kmeancenter );
		county = Kmean.count(measurlisto, Kmeancenter );

		
		cluster = Kmean.clusters(measurlisto, Kmeancenter);
		
		System.out.println("Printing Cluster Number (Sorted)");
			System.out.println("******************************************************************************************************");

			
			
   			System.out.println("Number of samples in Cluster 1: " + county[0]);
   			System.out.println("Number of samples in Cluster 2: " + county[1]);
   			System.out.println("Number of samples in Cluster 3: " + county[2]);
   			System.out.println("Number of samples in Cluster 4: " + county[3]);

			
		
		System.out.println("******************************************************************************************************");

		
		

		
		//double[][] denormameasurlisto = test1.Measuredenormalised(clustermain,Kmeancenter);

		System.out.println("Printing Latest Cluster Centroids.......");
		System.out.println("******************************************************************************************************");
		
		for(int k=0; k<4; k++) {
			System.out.println("For Cluster    "+(k+1));

		for (int i=0; i<18; i++) {
				System.out.println(clustermain[k][i]+",");
		}System.out.println();
		}
		
		System.out.println("******************************************************************************************************");

		
		double[][] anaglisto = test1.pointofanalog();
		//double[][] normanaglisto = test1.Measurenormalised4test(anaglisto);
		
		
	//double[][] disp1cluster = Kmean.cluster1_label();
	
		
	///for (int i=0; i<disp1cluster.length; i++) {
		//System.out.println(disp1cluster[i]);
		//ArrayList<Valuesget> list = new ArrayList<Valuesget>();
	    //for (double[] array : normameasurlisto) {
	     //   list.add((Assignmentmain) Arrays.asList(array));
	    //}
	    
	   // list.stream().forEach(System.out::println);
		
		/*
		 * for(int k=0; k<200; k++) {
		 
			for (int i=0; i<18; i++) {
					list.add(test1.Measurenormalised(measurlisto));
			}
		
			*/
		
		
		
		
			
		

		
		KNN knnobj = new KNN();
		
		knnlist= knnobj.algorithm(measurlisto, anaglisto);
		
		//double[][] analog = test1.C_Final_Measurenormalisttest();
		
           Testsort to = new Testsort();
           
           sorted = to.printTable(knnlist,cluster);
           
                  
           

   	}
          
	
	
	
	
	
	
	
	private JFrame frmSmartPowerSystem;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JTextField txtDatabase;
	private JTextField txtHost;
	private JTextField txtLearnSet; 
	private JTextField txtTestSet;
	private JTable tblSets;
	private JTable tblSets1;

	
	JLabel lblCentroid1, lblCentroid2, lblCentroid3, lblCentroid4;
	
	public static void main(String[] agrs) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assignmentmain.amain();
					Assignmentmain window = new Assignmentmain();
					window.frmSmartPowerSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Assignmentmain() throws IOException {
		initialize();
	}
	
	private void initialize() throws IOException {
		frmSmartPowerSystem = new JFrame();
		frmSmartPowerSystem.setTitle("Machine Learning in Power System");
		frmSmartPowerSystem.setBounds(100, 100, 1169, 533);
		frmSmartPowerSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmartPowerSystem.getContentPane().setLayout(null);
		
		
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.setBounds(20, 450, 1110, 25);
		btnExecute.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				
				Assignmentmain.amain(); //execute main routine.
				
					
				double[] count = new double[4];
				KmeansClustering Kmean1 = new KmeansClustering();

			
				count= county;
				
				lblCentroid1.setText("GUI for Data profile" );
				lblCentroid2.setText("Press Execute to get the results" );
				lblCentroid3.setText("Done by" );
				lblCentroid4.setText("Balaji Nagaraj Kumar" );
				
				
				
				DefaultTableModel testtable = new DefaultTableModel();	
				tblSets1.setSize(200,100);
				String[] columnName = {"Attribute","Values"};				
				for (int i = 0; i < columnName.length; i++) {
					testtable.addColumn(columnName[i]);
				}
				
				String row1 = new String();
				row1 = Double.toString(measurlisto.length);
				String row2 = new String();
				row2 = Double.toString(county.length);
				String row3 = new String();
				row3 = Double.toString(knnlist[0].length);
				
				String row4 = new String();
				String row5 = new String();
				String row6 = new String();
				String row7 = new String();
				String row8 = new String();
				String row9 = new String();
				String rowa = new String();
				String rowb = new String();
				
				double[] clusteru = new double[200];
				clusteru = Kmean1.clusters(measurlisto, Kmeancenter);
				int c1=0, c2=0, c3=0,c4=0;
				
				
				
				for (int i=0; i<200; i++)
				{
					if(clusteru[i]==1)
						c1++;
					else if (clusteru[i]==2)
						c2++;
					else if (clusteru[i]==3)
						c3++;
					else if (clusteru[i]==4)
						c4++;
				}
				
				row4 = Double.toString(c1);
				row5 = Double.toString(c2);
				row6 = Double.toString(c3);
				row7 = Double.toString(c4);

				/*
				if (c1==49)
				{
				row4 = Double.toString(c1);
				}
				else if (c2==49)
				{
					row4 = Double.toString(c2);
				}
				else if (c3==49)
				{
					row4 = Double.toString(c3);
				}
				else if (c4==49)
				{
					row4 = Double.toString(c4);
				}
				
				if (c1==51)
				{
				row5 = Double.toString(c1);
				}
				else if (c2==51)
				{
					row5 = Double.toString(c2);
				}
				else if (c3==51)
				{
					row5 = Double.toString(c3);
				}
				else if (c4==51)
				{
					row5 = Double.toString(c4);
				}
				
				
				if (c1==47)
				{
				row6 = Double.toString(c1);
				}
				else if (c2==47)
				{
					row6 = Double.toString(c2);
				}
				else if (c3==47)
				{
					row6 = Double.toString(c3);
				}
				else if (c4==47)
				{
					row6 = Double.toString(c4);
				}
				
				
				if (c1==53)
				{
				row7 = Double.toString(c1);
				}
				else if (c2==53)
				{
					row7 = Double.toString(c2);
				}
				else if (c3==53)
				{
					row7 = Double.toString(c3);
				}
				else if (c4==53)
				{
					row7 = Double.toString(c4);
				}
				
				
				*/

				

				testtable.addRow(new Object[]{"Number of Training Data", row1});
			
				testtable.addRow(new Object[]{"No.of sample belonging to Cluster 1",row4 });
				testtable.addRow(new Object[]{"Number of sample belonging to Cluster 2",row5 });
				testtable.addRow(new Object[]{"Number of sample belonging to Cluster 3",row6 });
				testtable.addRow(new Object[]{"Number of sample belonging to Cluster 4",row7 });
				testtable.addRow(new Object[]{"", ""});
				testtable.addRow(new Object[]{"Number of Clusters", row2});
				testtable.addRow(new Object[]{"", ""});

				testtable.addRow(new Object[]{"Number of Test Data",row3 });
				
		        Testsort teso = new Testsort();
		        int[] countu = new int[4];
		        countu = teso.countvangiko();

		        row8 = Double.toString(countu[0]);
				row9 = Double.toString(countu[1]);
				rowa = Double.toString(countu[2]);
				rowb = Double.toString(countu[3]);
				
				testtable.addRow(new Object[]{"Number of Test Data labelled under cluster 1",row8 });
				testtable.addRow(new Object[]{"Number of Test Data labelled under cluster 2",row9 });
				testtable.addRow(new Object[]{"Number of Test Data labelled under cluster 3",rowa });
				testtable.addRow(new Object[]{"Number of Test Data labelled under cluster 4",rowb });


				tblSets1.setModel(testtable);
				
				
				JFrame frame = new JFrame("Charts");
				frame.setSize(600,600);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                XYDataset ds = createDataset();
                JFreeChart chart = ChartFactory.createScatterPlot("Train Data",
                        "Angle", "Voltage", ds);

                ChartPanel cp = new ChartPanel(chart);
                frame.getContentPane().add(cp);
                
			}
		});
		frmSmartPowerSystem.getContentPane().add(btnExecute);
		
		JLabel lblDatabase = new JLabel(":");
		lblDatabase.setBounds(20, 68, 63, 14);
		
		txtDatabase = new JTextField();
		txtDatabase.setBounds(93, 65, 86, 20);
		txtDatabase.setText("");
		txtDatabase.setColumns(10);
		
		JLabel lblHost = new JLabel("");
		lblHost.setBounds(20, 39, 52, 14);
		
		txtHost = new JTextField();
		txtHost.setBounds(93, 36, 86, 20);
		txtHost.setText("");
		txtHost.setColumns(10);
		
		txtLearnSet = new JTextField();
		txtLearnSet.setBounds(954, 36, 99, 20);
		txtLearnSet.setText("");
		txtLearnSet.setColumns(10);
		
		txtTestSet = new JTextField();
		txtTestSet.setBounds(954, 61, 99, 20);
		txtTestSet.setText("");
		txtTestSet.setColumns(10);
		
		JLabel lblLearnSet = new JLabel("");
		lblLearnSet.setBounds(891, 39, 74, 14);
		
		JLabel lblTestSet = new JLabel("");
		lblTestSet.setBounds(891, 64, 63, 14);
		
		JLabel lblKthRoyalInstitute = new JLabel("");
		lblKthRoyalInstitute.setBounds(418, 53, 255, 20);
		lblKthRoyalInstitute.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblLearntestSets = new JLabel("");
		lblLearntestSets.setBounds(891, 11, 146, 14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 168, 1110, 279);
		frmSmartPowerSystem.getContentPane().add(scrollPane);
		
		tblSets = new JTable();
		tblSets.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {"Attribute","Values"}
		));
		scrollPane.setViewportView(tblSets);
		
		tblSets1 = new JTable();
		tblSets1.setSize(200,100);
		tblSets1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {"Attribute","Values"}
		));
		scrollPane.setViewportView(tblSets1);
		
		JLabel lblAssignmentIi = new JLabel("EH2745 Computer Applications in Electric Power Systems Assignment 2");
		lblAssignmentIi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAssignmentIi.setBounds(200, 19, 700, 25);
		frmSmartPowerSystem.getContentPane().add(lblAssignmentIi);
		
		
	
		
		
		
		lblCentroid1 = new JLabel("   GUI for Data profiling");
		lblCentroid1.setBounds(447, 79, 170, 25);
		frmSmartPowerSystem.getContentPane().add(lblCentroid1);

		
		lblCentroid2 = new JLabel("Press Execute to get results");
		lblCentroid2.setBounds(447, 102, 190, 20);
		frmSmartPowerSystem.getContentPane().add(lblCentroid2);

		
		lblCentroid3 = new JLabel("      Done by ");
		lblCentroid3.setBounds(447, 123, 192, 25);
		frmSmartPowerSystem.getContentPane().add(lblCentroid3);

		
		lblCentroid4 = new JLabel("Balaji Nagaraj Kumar");
		lblCentroid4.setBounds(447, 150, 236, 14);
		frmSmartPowerSystem.getContentPane().add(lblCentroid4);

	}
	
	private static XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        //double[][] data = new double[200][18];
        	
        /*
        for(int k=0; k<200; k++) {
    		for (int i=0; i<18; i++) {
    				data[k][i]=measurlisto[k][i];
    		}
        }*/
        	
        	String a = "root";
    		String b= "balsun";
    		Valuesget test2 = new Valuesget(a,b);
    		KmeansClustering Kmean1 = new KmeansClustering();

    		int ki =0;
    		double[][] data= test2.graphdata();
    		double[] clusteru = new double[200];
			clusteru = Kmean1.clusters(measurlisto, Kmeancenter);
    		
    		
    		
    		
        	
        ds.addSeries("series3", data);

        return ds;
    }
	
	}
	


