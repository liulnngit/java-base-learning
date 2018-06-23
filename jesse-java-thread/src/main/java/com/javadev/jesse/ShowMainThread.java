package com.javadev.jesse;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 启动一个Main线程，jvm启动的线程
 * 6:Monitor Ctrl-Break
 * 5:Attach Listener
 * 4:Signal Dispatcher
 * 3:Finalizer
 * 2:Reference Handler
 * 1:main

 */
public class ShowMainThread {

    public static void main(String[] args){
        //java虚拟机的线程管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取线程信息的方法
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo:threadInfos){
            System.out.println(threadInfo.getThreadId()+":"+threadInfo.getThreadName());

        }

    }

}

/**
 * idea 快捷键
 * main方法生成psvm
 * for循环 fori
 * 打印方法 sout
 */