package com.test;

import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterBFTest {
	
	private static final int NUM = 500;
	private static CountDownLatch cdl = new CountDownLatch(NUM);
	private Object obj = new Object();
	public void countDownLatchTest(BloomFilter<String> bf){
		for (int i = 0; i < NUM; i++) {
			new Thread(new Request(i,bf)).start();
			cdl.countDown();
		}
	}
	
	
	class Request implements Runnable{
		private int num;
		private BloomFilter<String> bf;
		
		public Request(int num,BloomFilter<String> bf) {
			this.num = num;
			this.bf = bf;
		}

		@Override
		public void run() {
			try {
				cdl.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			putBloom(bf,num);
			System.out.println("Thread-"+num+" ======"+System.currentTimeMillis());
		}
		
		//其中布隆过滤器的写入操作是线程不安全的  并不能解决并发问题
		public synchronized void putBloom(BloomFilter<String> bf,int num){
			bf.put(String.valueOf(num));
			System.out.println("放入Bloom:"+num);
		}
		
		/*public void putBloom(BloomFilter<String> bf,int num){
			synchronized (obj) {
				bf.put(String.valueOf(num));
				System.out.println("放入Bloom:"+num);
			}
		}*/
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		BloomFilterBFTest bfTest = new BloomFilterBFTest();
		final BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), NUM,0.01);
		bfTest.countDownLatchTest(bf);
		System.out.println("=====================");
		Thread.sleep(1000);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < NUM; i++) {
					System.err.println(i+",Bloom contain "+i+":"+bf.mightContain(String.valueOf(i)));
				}
			}
		}).start();
	}
	
	
}
