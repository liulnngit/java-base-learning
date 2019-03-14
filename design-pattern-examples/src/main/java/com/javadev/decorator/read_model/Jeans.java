package com.javadev.decorator.read_model;

//concrete decoratorB of Boy
public class Jeans extends Finery{
    public void show(){
        person.show();
        System.out.println("fashoin Jeans");
    }
}