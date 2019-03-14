package com.javadev.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
    
    public static void main(String[] args) {
        //创建固定线程数的线程池
        ExecutorService executors = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread(""+i);
            executors.execute(worker);
        }
        executors.shutdown();
        while(!executors.isTerminated()){
        }
        System.out.println("all threads Finished!");
    }
}   
