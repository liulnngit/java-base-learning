package com.javadev.command.read_model;

//命令抽象类
public abstract class Command{
	
    protected Barbecuer barbecuer;

    public Command(Barbecuer barbecuer){
        this.barbecuer = barbecuer;
    }

    public void setBarbecuer(Barbecuer barbecuer){
        this.barbecuer = barbecuer;
    }

    public abstract void executeCommand();

    public abstract String getString();
}