package com.syning.redis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jedis02 {


    public static void main(String[] args) {

        // 创建 Jedis 对象
        Jedis jedis = new Jedis("192.168.3.129", 6379);
        // 身份验证
        jedis.auth("syning");
        // ping 测试
        String ret = jedis.ping();
        System.out.println(ret);  // PONG

    }


    // 操作 key
    @Test
    public void testSet() {

        // 创建 Jedis 对象
        Jedis jedis = new Jedis("192.168.3.129", 6379);
        jedis.auth("syning");


//        // 添加
//        jedis.set("name", "宁");
//
//        // 获取
//        String name = jedis.get("name");
//
//        System.out.println(name);
        //jedis.mset("age", "4000", "address", "大冥山");
        //List<String> lst = jedis.mget("name", "age", "address");
        //System.out.println(lst);



        // 添加 List 集合
        //Long l = jedis.rpush("add", "大冥山", "不夜天", "云深不知处", "青丘");
        //System.out.println(l);


        // 添加到 hash 集合中
        Map<String, String> map = new HashMap<>();
        map.put("姓名", "宁");
        map.put("年龄", "4000");
        map.put("住址", "大冥山");
        jedis.hset("user", map);





    }


    @Test
    public void getSet() {

        // 创建 Jedis 对象
        Jedis jedis = new Jedis("192.168.3.129", 6379);
        jedis.auth("syning");


        // 获取 List 集合中的元素
//        List<String> lst = jedis.lrange("add", 0, -1);
//        System.out.println(lst);

        // 获取 hash 列表的 key 和 value 值
        List<String> valList = jedis.hvals("user");
        Set<String> keySet = jedis.hkeys("user");

        System.out.println("keySet = " + keySet);
        System.out.println("valList = " + valList);



    }







}
