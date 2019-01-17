package com.example.demo.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinerySearchImpl {
	@Autowired
	private SortAlogrithm sort;
	
 public int binerySearch(int[] arr,int itemToSearchFor) {
	 sort.sort(arr);
	 System.out.println(sort);
	 
	 return 3;
 }
}
