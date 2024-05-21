package com.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayLists1 {
	
	public static void main(String[] args) {
		
		List<Object>arrayList1 = new ArrayList<>();
		
		arrayList1.add(24);
		arrayList1.add("Sahithya");
		arrayList1.add('B');
		arrayList1.add(24.02);
		arrayList1.add(10.08f);
		
		System.out.println(arrayList1.get(0));
		System.out.println();
		
		for(int index=0;index<5;index++)
		{
			System.out.println(arrayList1.get(index));
		}
		
		for(int index=0;index<arrayList1.size();index++)
		{
			System.out.println(arrayList1.get(index));
		}
	}

}
