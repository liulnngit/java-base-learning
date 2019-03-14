package com.javadev.chain_of_responsibility;

public class ConcreteHandle3 extends Handler{

	@Override
	public void handleRequest(int request) {
		if(request>=20 && request <30){
			System.out.println(this.getClass().getSimpleName()+" handle "+request);
		}else{
			successor.handleRequest(request);
		}
	}
	
}
