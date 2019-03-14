package com.javadev.concurrency.queue;

public class Message {
    private String msg;
    
    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

}

