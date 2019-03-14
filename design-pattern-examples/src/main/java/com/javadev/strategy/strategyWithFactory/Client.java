package com.javadev.strategy.strategyWithFactory;

/**
 * 策略模式与工厂模式的集成
 * 
 * 总结：
 * 	1、每个算法类封装了不同的实现，但完成的是相同的工作，这样就把算法实现类与使用算法类的类解耦
 * 	2、简化了单元测试
 * 	3、对外暴露了更少的实现细节，符合开开放-关闭原则
 * 	4、当算法实现类不断增加的时候，在Context类增加switch分支会越来越多。
 * 
 */
public class Client {
    public static void main(String[] args) {
        Context c = new Context();
        c.contextInterface(1);
        c.contextInterface(2);
        c.contextInterface(3);
    }
}
