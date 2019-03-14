package com.javadev.singleton;

/**
 * 懒汉式单例模式
 * 	同步一个方法可能造成程序执行效率下降100倍，完全没有必要每次调用getInstance都加锁，
 * 	事实上我们只想保证一次初始化成功，其余的快速返回而已,如果在getInstance频繁使用的地方就要考虑重新优化了.
 */
public class LazySingleton {
	private static LazySingleton singleton;
	
	private LazySingleton(){}
	
	public synchronized static LazySingleton getInstance(){
		if(singleton ==null){
			return new LazySingleton();
		}
		return singleton;
	}
	
}
