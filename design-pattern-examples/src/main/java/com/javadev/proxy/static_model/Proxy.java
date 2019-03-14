package com.javadev.proxy.static_model;

public class Proxy implements Subject {
	
	private Subject subject;
	
	public Proxy(Subject subject) {
		super();
		this.subject = subject;
	}

	public void request() {
		System.out.println("Proxy start invoked.");
		subject.request();
		System.out.println("Proxy end invoked.");
	}

}
