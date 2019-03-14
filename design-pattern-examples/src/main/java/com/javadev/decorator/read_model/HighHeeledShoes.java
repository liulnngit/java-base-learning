package com.javadev.decorator.read_model;

//concrete decoratorC of girl 
public class HighHeeledShoes extends Finery {
    public void show(){
        person.show();
        System.out.println("sexy high-heel shoes");
    }
}