package com.javadev.factory.factory_method;

public class OracleDBSource implements IDBSource {

	public void getConnection() {
		System.out.println("get Oracle Connection.");
	}

}
