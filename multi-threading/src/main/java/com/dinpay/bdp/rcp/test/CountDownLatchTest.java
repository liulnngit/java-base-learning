package com.dinpay.bdp.rcp.test;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

/**
 * 通过countdownlatch的机制，来实现并发运行
 * 模拟200个并发测试
* @author ll
* @date 2018年4月18日 下午3:55:59
 */
public class CountDownLatchTest {
    
    private static final int threadnum = 200;
    
    public CountDownLatch cd = new CountDownLatch(threadnum);
    
    
    @Test
    public void TestCountDownlatch() throws InterruptedException{
        for (int i = 0; i < threadnum; i++) {
            new Thread(new Request()).start();
            cd.countDown();
        }
        /*
         * 在多线程编程中,Thread.CurrentThread 表示获取当前正在运行的线程，join方法是阻塞当前调用线程，
         * 直到某线程完全执行才调用线程才继续执行，
         * 如果获取的当前线程是主线程，调用Join方法,阻塞主线程
         */
        Thread.currentThread().join();
        //Thread.sleep(millis);
    }
    
    class Request implements Runnable{
        
        @Override
        public void run() {
            try {
                cd.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
           System.out.println(Thread.currentThread()+"get one,"+System.currentTimeMillis());
        }
        
    }
    
}


