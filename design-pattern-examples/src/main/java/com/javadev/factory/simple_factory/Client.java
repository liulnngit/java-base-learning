package com.javadev.factory.simple_factory;

/**
 * 创建型模式：简单工厂模式
 * 好处：
 * 	可以根据客户端动态创建相应的实例，消除了对具体产品的依赖
 * 	是java的封装，继承，多态，体现了OOP思想
 * 	
 * 不足：
 * 	违背了开闭原则(对外扩展打开，对内修改关闭)，一旦有新需求，尽量不修改原有代码，而是尽量进行新模块的扩展。
 * 	比如说现在我们现在需要生产ProductC，则需要修改Factory类的方法，增加if判断
 * 	
 */
public class Client {
    public static void main(String[] args) {
        IProduct p1 = Factory.getProduct(1);
        IProduct p2 = Factory.getProduct(2);
        p1.getProperty();
        p2.getProperty();
    }
}
