package com.dinpay.bdp.rcp.test;

import java.util.ArrayList;
import java.util.List;

import com.dinpay.bdp.rcp.IDSolution.CodisUtil;

import redis.clients.jedis.Jedis;

public class TestID {
    
    static List<String> list = new ArrayList<String>();
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                    setValue(getValue());
                }
            }).start();
        }
        
        Thread.sleep(2000);
        
    }
    
    public static String getValue(){
        Jedis jedis = CodisUtil.getJedisPool().getResource();
        try {
            String val = jedis.get("incrkey1");
            System.out.println(Thread.currentThread()+"-"+val);
            if(list.contains(val)){
                System.err.println("列表已经包含了："+val);
            }
            list.add(val);
            return val;
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
    
    public static void setValue(String value){
        Jedis jedis = CodisUtil.getJedisPool().getResource();
        try {
           jedis.set("incrkey1",String.valueOf(Integer.parseInt(value)+1));
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
    
    
}
