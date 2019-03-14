package com.dinpay.bdp.rcp.IDSolution;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/** 
* @ClassName: CodisUtil 
* @date 2018年2月7日 上午11:35:00 
*  
*/
public class CodisUtil {
    
    private static JedisPool pool = null;
    

    public static JedisPool getJedisPool() {
        if (pool == null) {
        	JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(500);
            config.setMaxIdle(5);
            config.setMaxWaitMillis(100000);
            config.setTestOnBorrow(true);
            pool = new JedisPool(config, "192.168.46.161",19000);
        }
        return pool;
    }
    

    
   
    
}
