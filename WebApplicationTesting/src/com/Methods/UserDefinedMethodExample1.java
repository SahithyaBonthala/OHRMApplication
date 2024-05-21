package com.Methods;

public class UserDefinedMethodExample1 {
	 private void Subtraction1()
		{
			int var1=20;
			int var2=10;
			int var3;
			
			var3=var1-var2;
			System.out.println(var3);
			
		}
	
	public static void main(String[] args) {
		
		UserDefinedMethodExample1 m2 = new UserDefinedMethodExample1();
		m2.Addition();
		m2.Subtraction();
		m2.Subtraction1();
	}

	public void Addition()
	{
		int var1=20;
		int var2=10;
		int var3;
		
		var3=var1+var2;
		System.out.println(var3);
		
	}
     void Subtraction()
	{
		int var1=20;
		int var2=10;
		int var3;
		
		var3=var1-var2;
		System.out.println(var3);
		
	}
}
