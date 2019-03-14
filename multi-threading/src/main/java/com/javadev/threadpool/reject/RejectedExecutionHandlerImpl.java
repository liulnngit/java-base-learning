package com.javadev.threadpool.reject;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池的拒绝策略
 */
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
          System.out.println(r.toString()+" is rejected");
    }
       
}
