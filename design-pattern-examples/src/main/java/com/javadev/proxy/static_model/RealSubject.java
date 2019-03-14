package com.javadev.proxy.static_model;

public class RealSubject implements Subject {

	public void request() {
		System.out.println("Real subject invoked.");
	}

}
