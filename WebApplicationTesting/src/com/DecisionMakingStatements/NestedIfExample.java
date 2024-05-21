package com.DecisionMakingStatements;

public class NestedIfExample {
	public static void main(String[] args) {
		
		int var=29;
		int var1=16;
		int var2=16;
		
		if(var>var1)
		{
			if(var1==var2)
			{
				System.out.println(" NestedIfExample");
			}
			System.out.println(" TrueBlock");
		}
	}

}
