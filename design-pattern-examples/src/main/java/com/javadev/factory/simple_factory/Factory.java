package com.javadev.factory.simple_factory;

public class Factory {
    public static IProduct getProduct(int type){
        if(type == 1){
            return new ProductA();
        }else if(type == 2){
            return new ProductB();
        }else{
            System.out.println("Sorry we don't product it");
            return null;
        }
    }
}
