package com.javadev.decorator;

//具体的装饰对象，起到给Component增加职责的功能
public class ConcreteDecoratorA extends Decorator{
    public ConcreteDecoratorA(){

    }
    public ConcreteDecoratorA(Component component){
        super.component = component;
    }
    @Override
    public void operation(){
        System.out.println("DecoratorA invoked!");
        super.operation();
    }
}
