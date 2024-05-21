package com.Methods;

public class UserDefinedMethodExample2 {
	
	public void Multiplication()
	{
		int var1=20;
		int var2=10;
		int var3;
		
		var3=var1*var2;
		System.out.println(var3);
	}
	
	public static void main(String[] args) {
		
		UserDefinedMethodExample2 m3 = new UserDefinedMethodExample2();		
		m3.Multiplication();
		
		UserDefinedMethodExample1 m2 = new UserDefinedMethodExample1();
		m2.Addition();
		m2.Subtraction();
		m2.Subtraction();
}

}
