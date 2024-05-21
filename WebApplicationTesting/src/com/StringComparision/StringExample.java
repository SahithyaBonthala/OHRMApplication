package com.StringComparision;

public class StringExample {
	
	public static void main(String[] args) {
		
		String var="Sahithya";
		String var1="Sannyu";
		
		if(var.equals(var1))
		{
			System.out.println(" var variable value is EQUAL to var1 variable value ");
		}
		else
		{
			System.out.println(" var variable is NOT EQUAL to var1 variable value ");
		}
		
		
		String var2="LiveTech";
		String var3="Livetech";
		
		if(var2.equals(var3))
		{
			System.out.println(" var2 variable value is EQUAL to var3 variable value ");
		}
		else
		{
			System.out.println(" var2 variable is NOT EQUAL to var3 variable value ");
		}
		
		
		if(var2.equalsIgnoreCase(var3))
		{
			System.out.println(" var2 variable value is EQUAL to var3 variable value ");
		}
		else
		{
			System.out.println(" var2 variable is NOT EQUAL to var3 variable value ");
		}
		
		String var4="Tech";
		String var5="Livetech";
		
		if(var5.contains(var4))
		{
			System.out.println(" String Exist");
		}
		else
		{
			System.out.println(" String NOT Exist");
		}
		
		System.out.println(" *********Finding the Number of characters of a String *********");
		
		int hello=var.length();
		System.out.println(hello);
		
		int varVariableLength=var.length();
		int var1VariableLength=var1.length();
		
		System.out.println(" The number of characters of the var variable value is :- "+varVariableLength);
		System.out.println(" The number of characters of the var1 variable value is :- "+var1VariableLength);
		
		System.out.println();
		
		if(varVariableLength>var1VariableLength)
		{
			System.out.println(" var variable value is greater than var1 variable value ");
		}
		else
		{
			System.out.println(" var variable value is NOT greater than var1 variable value ");
		}
		
		System.out.println();
		
		if(var1.length()>var.length())
		{
			System.out.println(" var1 variable value is greater than var variable value ");
		}
		else
		{
			System.out.println(" var1 variable value is NOT greater than var variable value ");
		}
		
		String var6="LiveTech";

		System.out.println("  The character at the index 3 is   "+var6.charAt(3));

		System.out.println("  The character at the index 10 is   "+var6.charAt(4));
				
	}

}
