package com.javadev.factory.factory_method;

public class MysqlDBSource implements IDBSource {

	public void getConnection() {
		System.out.println("get Mysql Connection.");
	}

}
