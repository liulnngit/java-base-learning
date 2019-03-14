package com.javadev.concurrency.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {
    
    public static void main(String[] args) {
        //Creating BlockingQueue of Size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce message in queue
        new Thread(producer).start();
        //starting consumer to comsume message from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started!");
    }
}
