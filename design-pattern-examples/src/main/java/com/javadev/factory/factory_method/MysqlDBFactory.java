package com.javadev.factory.factory_method;

public class MysqlDBFactory implements IDBFactory{

	public IDBSource getDBSource() {
		return new MysqlDBSource();
	}
	
}
