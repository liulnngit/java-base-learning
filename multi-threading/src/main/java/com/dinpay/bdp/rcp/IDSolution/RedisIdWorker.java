package com.dinpay.bdp.rcp.IDSolution;

import redis.clients.jedis.Jedis;

public class RedisIdWorker {
    
    public static void main(String[] args) {
        Jedis jedis = CodisUtil.getJedisPool().getResource();
        Long value = jedis.incr("incrkey");
        System.out.println(value);
        
    }
}
