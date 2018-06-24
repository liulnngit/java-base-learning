package com.javadev.jesse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁操作模板
 */
public class RwLockTemplete {

    static final Map<String,String> map = new HashMap<String,String>();
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static Lock r = reentrantReadWriteLock.readLock();
    static Lock w = reentrantReadWriteLock.writeLock();

    public void put(){
        w.lock();
        try{
            // do my work.....
        }finally{
            w.unlock();
        }
    }

    public void get(){
        r.lock();
        try{
            // do my work.....
        }finally{
            r.unlock();
        }
    }

}
