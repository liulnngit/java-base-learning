package com.javadev.command;

/**
 * 命令类包含接收命令的对象属性,并且有执行命令的方法
 * @author ll-t150
 *
 */
public abstract class Command {
	
	protected Receiver receiver;
	
	public Command(Receiver receiver){
		this.receiver = receiver;
	}
	
	public abstract void execute();
	
}
