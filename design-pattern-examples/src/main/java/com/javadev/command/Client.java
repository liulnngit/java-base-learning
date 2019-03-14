package com.javadev.command;

/**
 * 行为型模式:命令模式
 *	所谓命令肯定有命令的发送者及命令的接收者,命令模式则是命令本身封装成一个对象,
 *	从而使命令接收者可以根据接收到的命令让不同的命令执行者执行具体的命令,使用命令模式可以让命令请求者排队并记录命令日志.
 *
 *	命令模式可以让你使用不同的请求对客户参数化.
 *	很显然，通过使用命令模式可以较容易地设计一个命令队列，最重要的是命令模式把命令请求的对象与具体执行命令的对象分隔开了，
 *  这样具体的命令执行者与命令请求者之间的耦合度就降低了。
 */
public class Client {
	
	public static void main(String[] args) {
		Receiver r = new Receiver();
		Command c = new ConcreteCommand(r);
		Invoker i = new Invoker();
		i.setCommand(c);
		i.executeCommand();
	}
	
}
