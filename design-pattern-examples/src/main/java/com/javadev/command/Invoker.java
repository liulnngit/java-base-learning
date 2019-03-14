package com.javadev.command;

/**
 * 发起命令者肯定有命令属性,执行命令的请求,交给命令本身执行
 * @author ll-t150
 *
 */
public class Invoker {
	private Command command;
	
	public void setCommand(Command command){
		this.command = command;
	}
	
	public void executeCommand(){
		command.execute();
	}
	
}
