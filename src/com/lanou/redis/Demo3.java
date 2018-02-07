package com.lanou.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Demo3 {
	private Jedis jedis;
	
	@Before
	public void setup() {
		// 链接redis服务器
		jedis = new Jedis("127.0.0.1",6379);
		
	}
	/**
	 * redis存储字符串
	 */
	@Test
	public void testString() {
//		jedis.set("name", "xinxin");//向key-->name中放入了value-->xinxin  
		System.out.println(jedis.get("name"));
		
		jedis.append("name", "is my lover");// 拼接
		 jedis.del("name");  //删除某个键
		 System.out.println(jedis.get("name"));
		 
		 jedis.mset("name","liuling","age","23","qq","476777XXX");
		 jedis.incr("age"); //进行加1操作
		 System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
	}
	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<>();
		  map.put("name", "xinxin");
	        map.put("age", "22");
	        map.put("qq", "123456");
	        jedis.hmset("user",map);
	        List<String> hmget = jedis.hmget("user", "name","age","qq");
	        
	        
	        
	        System.out.println(hmget);
	        System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null  
	        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2 
	        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true  
	        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key  
	        System.out.println(jedis.hvals("user"));//返回map对象中的所有value 
	        
	        Iterator<String> iter=jedis.hkeys("user").iterator();  
	        while (iter.hasNext()){  
	            String key = iter.next();  
	            System.out.println(key+":"+jedis.hmget("user",key));  
	        } 
	}
	

}
