package com.javadev.strategy;

public class Context {
	
	private Strategy strategy;

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	
	public void getStrategyAlgorithm(){
		strategy.algorithm();
	}
	
}
