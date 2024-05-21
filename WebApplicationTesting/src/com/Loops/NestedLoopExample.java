package com.Loops;


public class NestedLoopExample {
	public static void main(String[] args) {
		
		for(int i=5; i<=7; i++)
		{
			for(int j=1; j<=3; j++)
			{
				System.out.println(i + " Testing");
			}
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		for(int a=0; a<3; a++)
		{
			for(int b=0; b<2; b++)
			{
				System.out.println(b + " Selenium");
				System.out.println(a+b);
			}
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		for(int a=0;a<2;a++) // Outer Loop
		{
		   for(int b=1;b<=2;b++) // Inner Loop
		   {
		     System.out.print(" * ");
		   }
		 System.out.println();
		
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		for(int index=5; index>=1; index--)
		{
			for(int index1=index; index1>=2; index1--)
			{
				System.out.print(" * ");
			}
		System.out.println();	
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		for(int index=5; index>=1; index--)
		{
			for(int index1=index; index1>=2; index1--)
			{
				System.out.print(index1 + " ");
			}
		System.out.println();	
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		for(int index=1; index<=5; index++)
		{
			for(int index1=5; index1>=index; index1--)
			{
				System.out.print(index1 + " ");
			}
		System.out.println();
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		for(int index=5; index>=0; index--)
		{
			for(int index1=1; index1<=index; index1++)
			{
				System.out.print(index + " ");
			}
		System.out.println();
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%%%BREAK%%%%%%%%%%%");
		System.out.println();
		
		for(int i=5; i<=7; i++)
		{
			for(int j=1; j<=3; j=j+1)
			{
				System.out.println(i + " Testing");
				break;
			}
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%%CONTINUE%%%%%%%%%%%%");
		System.out.println();
		
		
		for(int i=5; i<=7; i++)
		{
			for(int j=1; j<=3; j++)
			{
				System.out.println(j + " Testing");
				continue;
			}
		System.out.println(i);
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%CONTINUE%%%%%%%%%%%%%");
		System.out.println();
		
		for(int i=5; i>0; i--)
		{
			if(i<=5)
			{
				System.out.println(i);
				continue;
			}
		System.out.println(i + " Selenium");
		}
		
		System.out.println();
		System.out.println(" %%%%%%%%%%%BREAK%%%%%%%%%%%%%");
		System.out.println();
		
		for(int i=5; i>0; i--)
		{
			if(i<=5)
			{
				System.out.println(i);
				break;
			}
		System.out.println(i + " Selenium");
		}
		
		

	}

}
