package com.javadev.chain_of_responsibility;

public class ConcreteHandle2 extends Handler  {
    @Override
    public void handleRequest(int request) {
        if(request >= 10 && request < 20){
            System.out.println(this.getClass().getSimpleName() + " handle " + request);
        }else if (successor != null){
            successor.handleRequest(request);
        }
    }
}