package com.Loops;

public class DoWhileLoop {
	public static void main(String[] args) {
		
		int var=11;
		
		do
		{
			
			System.out.println(" Testing");
			var=var-2;
			System.out.println(" The value of current variable var is " + var);
			
		}while(var>=3);
		
		System.out.println();
		System.out.println(" $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println();
		
		
		
		do
		{
			
			System.out.println(var + " WebDriver");
			var=var+5;
			System.out.println(" The value of current variable var is " + var);
			
		}while(var<25);
	}

}
