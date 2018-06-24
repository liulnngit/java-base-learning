package com.javadev.jesse;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道输入输出用于线程之间的数据传输，传输的媒介是内存
 * 应用场景：只适合一对一的通信
 */
public class PipeTransfer {

    private static class Print implements Runnable{
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
           int receive =0;
            try {
                while((receive=in.read())!=-1){
                    System.out.println((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //必须进行连接
        out.connect(in);

        Thread t1 = new Thread(new Print(in),"PrintThread");
        t1.start();
        int receive =0;
        try {
            while((receive=System.in.read())!=-1){
                out.write(receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

}
