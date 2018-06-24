package com.javadev.jesse.bq;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock和Condition 实现有界阻塞队列
 */
public class BlockingQueueLC<T> {
    private List queue = new LinkedList<T>();
    private final int limit;
    Lock lock = new ReentrantLock();
    private Condition needNotEmpty = lock.newCondition();
    private Condition needNotFull = lock.newCondition();


    public BlockingQueueLC(int limit) {
        this.limit = limit;
    }

    public void enqueue(T item) throws InterruptedException {
        lock.lock();
        try{
            while(this.queue.size()==this.limit){
                needNotFull.await();
            }
            this.queue.add(item);
            needNotEmpty.signal();
        }finally{
            lock.unlock();
        }
    }

    public  T dequeue() throws InterruptedException {
        lock.lock();
        try{
            while(this.queue.size()==0){
                needNotEmpty.await();
            }
            needNotFull.signal();
            return (T) this.queue.remove(0);
        }finally{
            lock.unlock();
        }
    }
}
