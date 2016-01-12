package com.os.u2redis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Jedis jedis = new Jedis("127.0.0.1");  
        jedis.connect();  
        jedis.set("key", "123");  
        String value = jedis.get("key");  
        System.out.println(value);
    }
}
