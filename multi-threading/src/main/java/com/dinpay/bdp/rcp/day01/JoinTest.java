package com.dinpay.bdp.rcp.day01;

public class JoinTest {
    
    public static void main(String[] args) throws InterruptedException {
        join();
    }
    
    private static void join() throws InterruptedException{
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"---running");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"---running2");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
        
        //等待线程1结束
        t1.join();
        //等待线程2结束
        t2.join();
        System.out.println("main over!");
    }
}
