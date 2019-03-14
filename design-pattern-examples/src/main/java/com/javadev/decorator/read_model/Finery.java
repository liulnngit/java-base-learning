package com.javadev.decorator.read_model;

//abstract decorator 
public abstract class Finery extends Person{
    protected Person person;
    public void decorateComponent(Person person){
        this.person = person;
    }
    public abstract void show();
}