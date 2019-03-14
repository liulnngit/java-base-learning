package com.javadev.chain_of_responsibility;

public class ConcreteHandle1 extends Handler{

	@Override
	public void handleRequest(int request) {
		if(request>=0 && request<10){
			System.out.println(this.getClass().getSimpleName()+" handle "+request);
		}else{
			successor.handleRequest(request);
		}
	}
	
}
