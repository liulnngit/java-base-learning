package com.javadev.decorator.read_model;

//concrete decoratorA of Boy
public class TShirt extends Finery{
    public void show(){
        person.show();
        System.out.println("dashing T-shirt");
    }
}