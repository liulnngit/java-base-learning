package com.javadev.jesse;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock使用的通用模板
 */
public class LockTemplete {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            // do my work.....
        }finally{
            lock.unlock();
        }
    }

}
