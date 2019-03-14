package com.javadev.decorator.read_model;

//girl
public class Girl extends Person {
    public Girl(String name ){super(name);}

    public void show(){
        System.out.println("I am a girl named " + name);
    }
}