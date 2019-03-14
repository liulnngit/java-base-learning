package com.javadev.command.read_model;

//烤鸡翅命令
public class BakeChickenWithWingCommand extends Command{

    public BakeChickenWithWingCommand(Barbecuer barbecuer) {
        super(barbecuer);
    }

    public void executeCommand(){
        barbecuer.bakeChickenWithWing();
    }

    public String getString(){
        return "烤鸡翅";
    }
}