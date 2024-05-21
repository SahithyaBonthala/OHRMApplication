package com.Methods;

public class UserDefinedMethodExample3 {
	
	public void Addition()
	{
		int var1=20;
		int var2=40;
		int var3;
		
		var3=var1+var2;
		System.out.println(var3);
	}
	
	//global variables
	
	int var1=20; 
	int var2=10;
	double var3;
	
	public void Subtraction()
	{
		int var2=10;
		
		var3=var1+var2;
		System.out.println(var3);
	}
	
	public void Addition(int var1,int var2)
	{
		var3=var1+var2;
		System.out.println(var3);
	}
	public void Addition(int var1,double var2,double var3)
	{
		var3=var1+var2;
		System.out.println(var3);
	}
	
	public static void main(String[] args) {
	
		UserDefinedMethodExample3 m4 = new UserDefinedMethodExample3();
		m4.Addition();
		m4.Subtraction();
		m4.Addition(5, 5);
		m4.Addition(10, 20, 30);
		
	}

}
