package com.test;

import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class HighConcrrentBloomFilterTest {
	
	private static final int NUM = 500;
	private CountDownLatch cdl = new CountDownLatch(NUM);
	public BloomFilter<String> bf;
	
	@Before
	public void init(){
		bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), NUM,0.01);
	}
	
	@Test
	public void countDownLatchTest(){
		for (int i = 0; i < NUM; i++) {
			new Thread(new Request(i)).start();
			cdl.countDown();
		}
		
		System.out.println("=====================");
		for (int i = 0; i < NUM; i++) {
			System.err.println(i+",Bloom contain "+i+":"+bf.mightContain(String.valueOf(i)));
		}
		
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	class Request implements Runnable{
		private int num;
		
		public Request(int num) {
			this.num = num;
		}

		@Override
		public void run() {
			try {
				cdl.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			putBloom(num);
			System.out.println("Thread-"+num+" ======"+System.currentTimeMillis());
		}
		
		public synchronized void putBloom(int num){
			bf.put(String.valueOf(num));
			System.out.println("放入Bloom:"+num);
		}
	}
	
	
	
}
