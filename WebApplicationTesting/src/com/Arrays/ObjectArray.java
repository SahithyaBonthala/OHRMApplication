package com.Arrays;

public class ObjectArray {
	
	public static void main(String[] args) {
		
		Object array[] = new Object[4];
		
		array[0] = 24 ;
		array[1] = "Sahithya";
		array[2] = 'B';
		array[3] = 24.02;
		//array[4] = 10.08f;
		
		System.out.println(array[0]);
		System.out.println();
		
		for(int index=0;index<array.length;index++)
		{
			System.out.println(array[index]);
		}
		
		System.out.println();
		
		for(Object index:array)
		{
			System.out.println(index);
		}
				
	}

}
