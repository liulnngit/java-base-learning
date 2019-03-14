package com.javadev.adapter.clean_model;

//本土球员
public class NativeNBAPlayer extends Player{
    public NativeNBAPlayer(String name){super(name);}
    public void attack(){
        System.out.println("I am native NBA player, I am attacking!");
    }
} 