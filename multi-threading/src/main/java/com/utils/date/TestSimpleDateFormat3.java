package com.utils.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * 使用ThreadLocal对象
 * （1）创建了一个线程安全的SimpleDateFormat实例，
 * （3）在使用的时候首先使用get()方法获取当前线程下SimpleDateFormat的实例，在第一次调用ThreadLocal的get（）方法适合会触发其initialValue方法用来创建当前线程所需要的SimpleDateFormat对象。
 */
public class TestSimpleDateFormat3 {
	 // (1)创建threadlocal实例
    static ThreadLocal<DateFormat> safeSdf = new ThreadLocal<DateFormat>(){
        @Override 
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    
    public static void main(String[] args) {
        // (2)创建多个线程，并启动
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {// (3)使用单例日期实例解析文本
                            System.out.println(safeSdf.get().parse("2017-12-13 15:17:27"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();// (4)启动线程
        }
    }
}

