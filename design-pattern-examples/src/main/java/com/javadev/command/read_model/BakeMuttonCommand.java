package com.javadev.command.read_model;

//烤羊肉串命令
public class BakeMuttonCommand extends Command{

    public BakeMuttonCommand(Barbecuer barbecuer) {
        super(barbecuer);
    }

    public void executeCommand(){
        barbecuer.bakeMutton();
    }

    public String getString(){
        return "烤羊肉串";
    }
}