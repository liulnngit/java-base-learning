package com.javadev.factory.factory_method;

public class OracleDBFactory implements IDBFactory{

	public IDBSource getDBSource() {
		return new OracleDBSource();
	}
	
}
