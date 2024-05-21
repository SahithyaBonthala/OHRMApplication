package com.Loops;

public class WhileExample {
	public static void main(String[] args) {
		
		int var=24;
		
		while(var>2)
		{
			System.out.println(var + "-" + "Testing");
			var=var-4;
			System.out.println(" The value of current variable var is " + var);
		}
		
		System.out.println();
		System.out.println(" $$$$$$$$$$$$$$$$$$$$$");
		System.out.println();
		
		while(var<10)
		{
			System.out.println(var + "-" + " Selenium");
			var=var+3;
		}
	}

}
