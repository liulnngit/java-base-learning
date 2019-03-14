package com.javadev.decorator.read_model;

//concrete decoratorB  of girl 
public class Hat extends Finery {
    public void show(){
        person.show();
        System.out.println("white hat");
    }
}