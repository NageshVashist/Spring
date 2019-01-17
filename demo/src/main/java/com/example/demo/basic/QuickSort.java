package com.example.demo.basic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSort implements SortAlogrithm{

	@Override
	public int[] sort(int[] arr) {
		return arr;
	}

}
