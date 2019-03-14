package com.javadev.proxy.dynamic_model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{
	
	private Object target;
	
	public Object newInstance(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before Dynamic.");
		method.invoke(target, args);
		System.out.println("After Dynamic.");
		return null;
	}

}
