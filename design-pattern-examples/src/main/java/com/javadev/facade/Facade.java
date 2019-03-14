package com.javadev.facade;

public class Facade {
	
	private SubSystem1 one;
	private SubSystem2 two;
	private SubSystem3 three;
	
	public Facade() {
		super();
		this.one = new SubSystem1();
		this.two = new SubSystem2();
		this.three = new SubSystem3();
	}
	
	public void methodA(){
		one.methodOne();
		two.methodTwo();
	}
	
	public void methodB(){
		two.methodTwo();
		three.methodThree();
	}
	
	
	
}
