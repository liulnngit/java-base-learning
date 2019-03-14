package com.test;

/**
 * 本质上是个map，map的键就是每个线程对象，值就是每个线程所拥有的值。
 * initialValue() get() set(),remover()
 * Threadlocal 拥有的这个变量，在线程之间是独立的，互相之间没有联系，内存占用相对来说比较大
 * @author ll-t150
 *
 */
public class ThreadLocalTest {
	
	static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
		
		@Override
		protected String initialValue() {
			return "init";
		}
	};
	
	
	private static class T1 implements Runnable{
		
		private int id;
		
		public T1(int id) {
			super();
			this.id = id;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getId()+" start");
			String s = threadLocal.get();
			s = s+"_"+id;
			threadLocal.set(s);
			System.out.println(Thread.currentThread().getId()+s);
		}
	}
	
	public void test(){
		Thread[] runs = new Thread[3];
		for (int i = 0; i < runs.length; i++) {
			runs[i]= new Thread(new T1(i));
		}
		for (int i = 0; i < runs.length; i++) {
			runs[i].start();
		}
	}
	
	public static void main(String[] args) {
		ThreadLocalTest test = new ThreadLocalTest();
		test.test();
	}
	
	
	
}
