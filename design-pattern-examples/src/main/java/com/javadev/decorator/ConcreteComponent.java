package com.javadev.decorator;

//ConcreteComponent 是定义了一个具体的对象，也可以给这个对象增加职责
public class ConcreteComponent implements Component{

	public void operation() {
		System.out.println("concrete component.");
	}
	
}
