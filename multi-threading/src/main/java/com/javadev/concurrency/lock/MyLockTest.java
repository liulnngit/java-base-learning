package com.javadev.concurrency.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockTest {
	private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	private static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Thread thread = Thread.currentThread();
				lock.lock();
				try {
					System.err.println(thread.getName()+"获取到了锁");
					for (int i = 0; i < 5; i++) {
						arrayList.add(i);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					System.out.println(thread.getName()+"释放了锁");
					lock.unlock();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Thread thread = Thread.currentThread();
				lock.lock();
				try {
					System.err.println(thread.getName()+"获取到了锁");
					for (int i = 0; i < 5; i++) {
						arrayList.add(i);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					System.out.println(thread.getName()+"释放了锁");
					lock.unlock();
				}
			}
		}).start();
		
		for (Integer i : arrayList) {
			System.out.println(i);
		}
		
	}
}
