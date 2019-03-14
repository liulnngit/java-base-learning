package com.javadev.adapter.clean_model;

//抽象球员类
public abstract class Player {
	public String name;
	public Player(){}
	public Player(String name) {
		super();
		this.name = name;
	};
	
	public abstract void attack();
	
	
}
