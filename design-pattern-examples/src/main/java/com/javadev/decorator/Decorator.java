package com.javadev.decorator;

//Decorator,装饰抽象类，继承Component，从外类来扩展Component类的功能，但对于Component来说，是不需要知道Decorator存在的.
public abstract class Decorator implements Component{
	
	protected Component component;
	
	public Decorator(){

    }
    public Decorator(Component component){
        this.component = component;
    }
	
	public void operation() {
		if(component != null){
			component.operation();
		}
	}
	
}
