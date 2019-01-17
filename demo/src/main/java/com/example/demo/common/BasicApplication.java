package com.example.demo.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.basic.BinerySearchImpl;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BasicApplication.class, args);
		BinerySearchImpl bs=context.getBean(BinerySearchImpl.class);
		bs.binerySearch(new int []{1,4,4,4,4}, 5);
	}
}
