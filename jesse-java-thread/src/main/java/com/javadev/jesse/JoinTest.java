package com.javadev.jesse;

/**
 * Join 线程A执行了thread.join方法
 * 线程A会等待thread线程终止之后，A在join后面的语句才会继续执行
 */

public class JoinTest {

    static class CutInLine implements Runnable{

        private Thread thread;

        public CutInLine(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                //在被插队的线程里，调用一下插队线程的join方法
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" will work");
        }
    }

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread thread =
                    new Thread(new CutInLine(previous),String.valueOf(i));
            System.out.println(previous.getId()+" cut in the thread:"+thread.getName());
            thread.start();
            previous = thread;
        }

    }

}
