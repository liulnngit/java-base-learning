package com.javadev.command.read_model;
/**
 * 行为型模式：命令模式
 *  使用命令模式的方法，就是在命令发送者和命令执行者之间创建一个个命令接收者，从而使命令的请求和处理互不干扰，实现两者的解耦。
 *  
 *  使用命令模式的时候可以在增加新命令的时候更易扩展，可体现开放-关闭原则。
 *  总结：
 *  	1、把命令的发送者与命令的接收者分开，实现了两者的解耦
 *  	2、可以较容易的添加命令队列
 *  	3、在需要的时候，可以较容易的添加操作日志
 *  	4、允许接受请求的一方拒绝执行该命令
 *  	5、只有在真正需要添加类似撤销或者重做的功能的时候才考虑使用命令模式，在代码重构的时候可以较容易使用命令模式
 *  
 */
public class Client {
	
	public static void main(String[] args) throws InterruptedException {

        //create a barbecuer
        Barbecuer barbecuer = new Barbecuer();
        Waiter waiter = new Waiter();

        Command bakeChickenWithWingCommand = new BakeChickenWithWingCommand(barbecuer);
        Command bakeMuttonCommand = new BakeMuttonCommand(barbecuer);
        Command bakeLeeksCommand = new BakeLeeksCommand(barbecuer);

        waiter.setOrder(bakeChickenWithWingCommand);
        waiter.setOrder(bakeMuttonCommand);
        waiter.setOrder(bakeLeeksCommand);
        Thread.sleep(1000);
        waiter.remove(bakeLeeksCommand);

        waiter.notifyBarbecuer();
	}
}
