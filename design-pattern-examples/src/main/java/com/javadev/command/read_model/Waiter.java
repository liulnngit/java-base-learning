package com.javadev.command.read_model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//服务员
public class Waiter{
	
    private List<Command> commands = new ArrayList<Command>();

    //添加订单
    public void setOrder(Command command){
        if(command.getString().equals("烤鸡翅")){
            System.out.println("鸡翅卖完了");
        }else if(command.getString().equals("烤羊肉串")){
            commands.add(command);
            //记录日志
            System.out.println("添加订单 " + command.getString() + ";日期 " 
                + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        }
    }

    //删除订单
    public void remove(Command command){
        commands.remove(command);
        //记录日志
        System.out.println("删除订单 " + command.getString() + ";日期 " 
            + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    //通知给厨师
    public void notifyBarbecuer(){
        for(Command command : commands){
            command.executeCommand();
        }
    }

}