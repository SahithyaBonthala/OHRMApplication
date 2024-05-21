package com.DecisionMakingStatements;

public class ElseIfExample {
	public static void main(String[] args) {
		
		int var=11;
		int var1=10;
		int var2=28;
		
		if(var>var1 && var>var2)
		{
			System.out.println(" var variable value is greater than var1 and var2 variable values");
		}
		else
			if(var1>var2)
			{
				System.out.println(" var1 variable value is greater than var and var2 variable values");
			}
			else
				System.out.println(" var2 Variable value is greater than var and var2 variable value");
	}

}
