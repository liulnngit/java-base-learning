package com.dinpay.bdp.rcp.test;

import java.util.ArrayList;
import java.util.List;

import com.dinpay.bdp.rcp.IDSolution.CodisUtil;

import redis.clients.jedis.Jedis;

public class TestOneId {
    
    static List<String> list = new ArrayList<String>();
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+"-"+getValue());
                }
            }).start();
        }
        
        Thread.sleep(2000);
        //System.out.println(getValue());
    }
    
    public static long getValue(){
        Jedis jedis = CodisUtil.getJedisPool().getResource();
        try {
            long val = jedis.incr("incrkey");
            if(list.contains(val)){
                System.err.println("列表已经包含了："+val);
            }
            list.add(String.valueOf(val));
            return val;
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
}
