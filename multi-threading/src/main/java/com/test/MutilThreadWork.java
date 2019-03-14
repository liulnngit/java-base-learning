package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * 多线程工作
 */
public class MutilThreadWork {
	
	private static final int NUM = 20;
	
	private CountDownLatch cdl = new CountDownLatch(NUM);
	
	@Test
	public void test() throws InterruptedException {
		/*for (int i = 0; i < NUM; i++) {
			new Thread(new Worker(i)).start();
			cdl.countDown();
		}
		Thread.currentThread().join();*/
		final int count = 100;
		final AtomicInteger sum = new AtomicInteger(0);
		
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(sum.get() < count){
						synchronized (this) {
							int res = query(sum);
							System.out.println(sum.addAndGet(res));
						}
					}
				}
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(sum.get());
	}
	
	public int query(AtomicInteger sum){
		System.out.println("sum:"+sum);
		return 10;
	}
	
	
	
	class Worker implements Runnable{
		private int id;
		public Worker(int id) {
			this.id = id;
		}
		@Override
		public void run() {
			try {
				cdl.await();
				System.out.println("Thread-"+id+" start.");
				System.out.println("Thread-"+id+" end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
