package com.javadev.observer;

/**
 * 行为型模式：观察者模式
 * 
 * 应用场景：
 * 	当一个对象的状态发生改变导致其他对象的状态也发生改变，而不知道具体对象的状态需要改变的时候。
 *	使用抽象是为了降低关联对象的耦合，不依赖具体而是依赖抽象
 * 
 * 不足：
 * 	通知观察者时耗时
 * 	循环依赖问题
 * 	不存在Observer会对系统有影响。
 * 
 */
public class Client {
    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver ob1 = new ConcreteObserver(subject, "A");
        ConcreteObserver ob2 = new ConcreteObserver(subject, "B");
        subject.attach(ob1);
        subject.attach(ob2);

        subject.setSubjectState("ABC");
        subject.notifyOb();

        subject.setSubjectState("BDC");
        subject.notifyOb();
    }
}
