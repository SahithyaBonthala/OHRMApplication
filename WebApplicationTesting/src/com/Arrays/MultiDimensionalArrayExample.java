package com.Arrays;

public class MultiDimensionalArrayExample {
	public static void main(String[] args) {
		
		 String hello[][] = new String[2][2];
		// char hello[][] = new char[2][2];

		//boolean hello[][] = new boolean[2][2];
     /*
		hello[0][0]="Venkat Sir";
		hello[0][1]="Manual testing";

		hello[1][0]="Vishnu";
		hello[1][1]="Selenium";
		*/
		 
		//hello[1][1]='A';
		//hello[1][1]=false;
	

		// System.out.println(hello[1][0]);

		// should goto all the Rows
		for(int rowIndex=0;rowIndex<=1;rowIndex++)
		{
		// should goto a Row of all its Cells
		for(int rowOfCell=0;rowOfCell<=1;rowOfCell++)
		{
		//System.out.println(hello[0][1]);
		System.out.println(hello[rowIndex][rowOfCell]);
		}
		}

		System.out.println();
		System.out.println(" **************** ");


		// should goto all the Rows
		for(int rowIndex=0;rowIndex<=1;rowIndex++)
		{
		// should goto a Row of all its Cells
		for(int rowOfCell=0;rowOfCell<=1;rowOfCell++)
		{
		//System.out.println(hello[0][1]);
		System.out.print(hello[rowIndex][rowOfCell]+"  ");
		}
		System.out.println();
		}

	}

}
