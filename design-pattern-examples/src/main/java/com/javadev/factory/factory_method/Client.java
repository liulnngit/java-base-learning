package com.javadev.factory.factory_method;

/**
 * 创建型模式：工厂方法
 * @author ll-t150
 *	工厂方法定义一个用于创建对象的接口，让子类决定去实例化哪个对象，将对象的创建延迟到子类。
 *	当需要增加功能，我们只需要客户端的代码而不需要修改其他代码
 *	
 *比如：我们要增加SqlServer数据库源，只需要创建SqlServer对象工厂类(实现IDBFactory接口)就可以了
 *
 *符合开闭原则(对外扩展打开，对内修改关闭)。
 *
 */
public class Client {
	
	public static void main(String[] args) {
		IDBFactory oraleFactory = new OracleDBFactory();
		IDBFactory mysqlFactory = new MysqlDBFactory();
		IDBSource oracle = oraleFactory.getDBSource();
		IDBSource mysql = mysqlFactory.getDBSource();
		oracle.getConnection();
		mysql.getConnection();
	}
	
}
