package com.lanou.redis;

import redis.clients.jedis.Jedis;

public class Demo1 {

	public static void main(String[] args) {
		Jedis j = new Jedis("127.0.0.1",6379);
		
		j.select(1);// 选择数据库
		j.set("test", "123456");
		// 取值
		String value = j.get("test");
		System.out.println(value);
		
	}
}
