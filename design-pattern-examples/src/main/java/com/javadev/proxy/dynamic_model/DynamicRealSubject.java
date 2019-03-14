package com.javadev.proxy.dynamic_model;

public class DynamicRealSubject implements DynamicSubject {

	public String request() {
		System.out.println("Enter RealSubject.request()");
		return "DynamicRealSubject";
	}

}
