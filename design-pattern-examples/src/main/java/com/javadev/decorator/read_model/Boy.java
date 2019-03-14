package com.javadev.decorator.read_model;

//boy
public class Boy extends Person{
    public Boy(String name ){super(name);}

    public void show(){
        System.out.println("I am a boy named " + name);
    }
}