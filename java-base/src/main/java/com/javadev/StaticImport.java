package com.javadev;

//import static java.lang.Math.max;
import static java.lang.Math.abs;
import static java.lang.Math.max;

import com.javadev.annotations.AnnotationTest;

public class StaticImport {

	public static void main(String[] args){
		
		AnnotationTest.sayHello();
		int x = 1;
		try {
			x++;
		} finally {
			System.out.println("template");
		}
		System.out.println(x);
		
		
		System.out.println(max(3, 6));
		System.out.println(abs(3 - 6));
		
	}
}
