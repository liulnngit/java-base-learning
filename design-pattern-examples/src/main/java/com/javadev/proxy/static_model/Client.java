package com.javadev.proxy.static_model;

/**
 * 结构型模式：静态代理模式
 * @author ll-t150
 *	定义：给一个对象提供一个代理对象，并由代理对象控制原对象的引用。	
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Proxy p = new Proxy(new RealSubject());
		p.request();
	}
}
/**
Proxy start invoked.
Real subject invoked.
Proxy end invoked.
*
* 静态代理的缺点：
* 	1、例如我需要更改“Proxy start invoked”..内容我们需要增加代理类，会容易造成代理类的膨胀
* 	2、代理内容无法复用。
* 	3、接口增加方法，我们也需要在代理类也增加，若需要。
*/