package com.javadev.decorator.read_model;

//abstract person
public abstract class Person{
    //name
    protected String name;
    public Person(){}
    public Person(String name){this.name = name;}
    //show the appearance 
    public abstract void show();
    
}