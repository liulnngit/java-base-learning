package com.javadev.concurrency.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;


/**
 *我们通过一个简单的例子来介绍一下Fork/Join框架的使用。需求是求1+2+3+4的结果
 *使用Fork/Join框架首先要考虑到的是如何分割任务，如果希望每个子任务最多执行两个数的相加，那么我们设置分割的阈值是2，
 *由于是4个数字相加，所以Fork/Join框架会把这个任务fork成两个子任务，子任务一负责计算1+2，子任务二负责计算3+4，
 *然后再join两个子任务的结果。因为是有结果的任务，所以必须继承RecursiveTask
 *
 */
public class CountTask extends RecursiveTask<Integer>{
	
	private static final int THRESHOLD = 2;
	private int start;
	private int end;
	
	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	

	@Override
	protected Integer compute() {
		int sum = 0;
		//如果任务足够小就直接计算
		boolean canCompute = (end-start)<=THRESHOLD;
		if(canCompute){
			for (int i = start; i <=end; i++) {
				sum +=i;
			}
		}else{
			int middle = (end + start)/2;
			CountTask left = new CountTask(start, middle);
			CountTask right = new CountTask(middle+1, end);
			//执行子任务
			left.fork();
			right.fork();
			//获取子任务的结果
			int lResult = left.join();
			int rResult = right.join();
			sum = lResult+rResult;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		CountTask task = new CountTask(1, 4);
		Future<Integer> result = pool.submit(task);
		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
