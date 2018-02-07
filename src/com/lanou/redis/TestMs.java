package com.lanou.redis;
import com.lanou.Utils.MiaoSha;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import redis.clients.jedis.Jedis;

public class TestMs {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("iphone8","100");
        jedis.close();
        //玩多线程
        ExecutorService executor = Executors.newFixedThreadPool(20);

        for(int i = 0 ; i < 1000; i++){
            executor.execute(new MiaoSha("user"+i));
        }
        executor.shutdown();

    }

}