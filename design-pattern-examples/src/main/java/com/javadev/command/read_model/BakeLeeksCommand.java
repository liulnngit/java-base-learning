package com.javadev.command.read_model;

//烤韭菜命令
public class BakeLeeksCommand extends Command{

    public BakeLeeksCommand(Barbecuer barbecuer) {
        super(barbecuer);
    }

    @Override
    public void executeCommand() {
        barbecuer.bakeLeeks();
    }

    @Override
    public String getString() {
        return "烤韭菜";
    }

}