package com.javadev.chain_of_responsibility.dutyChain;

//管理人员抽象类
public abstract class Manager{
    protected String name;
    protected Manager superior;

    public Manager(String name,Manager superior){
        this(name);
        this.superior = superior;
    }

    public Manager(String name){this.name = name;}

    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    public void setSuperior(Manager superior){this.superior = superior;}
    public Manager getSuperior(){return superior;}

    public abstract void handleApplicationRequest(String content,double limit);
    public abstract String getHanldeObject();
}