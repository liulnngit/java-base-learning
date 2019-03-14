package com.javadev.proxy.dynamic_model;

/**
 * 结构型模式：动态代理模式
 * @author ll-t150
 *实现动态代理：
 *	1、获取要被代理的对象，也就是实际对象。
 *	2、实现InvocationHandler接口，生成实际的代理内容
 *	3、利用Proxy.newInstance()方法生成一个代理内容，第三个参数传入InvocationHandler的实现类
 *	4、代理对象调用接口内部的方法。
 *
 *优点：
 *	简化代码
 *	InvocationHandler接口的实现类可以实现复用
 *	使用动态代理，这就是AOP面向切面编程。
 *
 *动态代理的缺点：只能针对接口生成代理
 *
 *实际使用中，我们为某个单独的类实现代理也很正常，这种情况下我们就可以考虑使用CGLIB(一种字节码增强技术)来为某个类实现代理
 *
 */
public class Client {
	
	public static void main(String[] args) {
		DynamicProxy dp = new DynamicProxy();
		DynamicSubject drs = new DynamicRealSubject();
		DynamicSubject ds = (DynamicSubject) dp.newInstance(drs);
		ds.request();
	}
}
