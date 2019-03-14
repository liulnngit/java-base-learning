package com.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * 测试SimpleDateFormat是线程不安全实例
 * 更多了解http://ifeve.com/notsafesimpledateformat/
 */
public class TestSimpleDateFormat {
    //(1)创建单例实例
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        //(2)创建多个线程，并启动
        for (int i = 0; i <10 ; ++i) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {//(3)使用单例日期实例解析文本
                        System.out.println(sdf.parse("2017-12-13 15:17:27"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();//(4)启动线程
        }
    }
}
/**
 * 运行结果：java.lang.NumberFormatException: For input string: ""
 * 原因：每个线程都公用同一个sdf对象进行日期文本解析，并且使用了线程不安全的Calendar对象
 * 
 * 解决方式：
 * 1）、每次解析都new一个simpledateformat对象，缺点开销大
 * 2）、对sdf对象加同步synchronized锁，高并发情况下性能降低
 * 3）、使用ThreadLocal
 */
