package com.javadev.singleton;

/**
 * 饿汉式单例模式 (依赖jvm在加载类时创建唯一的单例实例)
 * 如果开销比较大，希望用到时才创建就要考虑延迟实例化,或者Singleton的初始化需要某些外部资源
 */
public class HungerSingleton {
	
	//jvm保证在任何线程访问singleton静态变量之前一定先创建了此实例  
	private static HungerSingleton singleton = new HungerSingleton();
	
	//私有的默认构造子，保证外界无法直接实例化 
	private HungerSingleton(){};
	
	//提供全局访问点获取唯一的实例  
	public static HungerSingleton getInstance(){
		return singleton;
	}
	
	
}
