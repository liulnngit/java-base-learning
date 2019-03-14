package com.javadev.decorator.read_model;

//concrete decoratorB of girl 
public class Skirt extends Finery {
    public void show(){
        person.show();
        System.out.println("beautiful skirt");
    }
}