package com.javadev.concurrency.waitnotify;

public class WaitNotifyTest {
    
    public static void main(String[] args) throws InterruptedException {
        Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();
        
        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();
        
        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        
        //new Thread(notifier, "notifier1").start(); 用于norify waiter1 ,或者用noftifyAll()方法全部唤醒
        
        Thread.currentThread().join();
        System.out.println("All the threads are started");
    }
}
/**
运行结果如下：
//waiter拿到Message的对象锁，然后释放该对象锁进入Waiting状态
waiter waiting to get notified at time:1526023614629
//waiter1拿到Message对象锁，然后释放该对象锁进入Waiting状态
waiter1 waiting to get notified at time:1526023614629
//notify调用Message对象的notify方法后
notifier started
//waiter获取锁，进入Running状态
waiter waiter thread got notified at time:1526023615630
waiter processed: notifier Notifier work done  


*/