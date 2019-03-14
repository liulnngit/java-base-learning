package com.dinpay.bdp.rcp.MyLeaning;

/**
 * 实现累加1000次后num的值
 * 100个线程进行累加最后的结果
 */
public class VolatileTest {
    
    public static volatile int num =0;
    
    public static void main( String[] args ) throws InterruptedException{
        
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                        @Override
                        public void run() {
                             for (int i = 0; i < 1000; i++) {
                                num++;
                                //System.out.println(Thread.currentThread()+"-"+num);
                            }
                        }
                    }).start();
        }
      
        
        Thread.sleep(2000);
        System.out.println("num:"+num);
    }
    
}
