package com.cdleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    StringRedisTemplate redisTemplate;


    @GetMapping("/redis")
    public String showRedis(){
//
//        long l = System.currentTimeMillis();
//        int idx = 0;
//
//        String[] uidList = new String[1000];
//
//        for(long i = 0; i < 100000L; i++){
//            String uid = UUID.randomUUID().toString();
//
//            redisTemplate.opsForValue().set(uid, String.valueOf(i));
//
//            if(i % 1000 == 0){
//                uidList[idx++] = uid;
////                System.out.println(" Set UUID  = " + uid);
//            }
//        }
//
//        long l2 = System.currentTimeMillis();
//
//        for(int i = 0; i < idx; i++){
//            String uid = uidList[i];
//
//            String id = redisTemplate.opsForValue().get(uid);
//
//            if(i % 10 == 0){
//                System.out.println(id);
//            }
//        }
//
//        long l3 = System.currentTimeMillis();
//
//
//        l3 -= l2;
//        l2 -= l;
//        System.out.println(" l3 - l2 = " + l3);
//        System.out.println(" l2 - l = " + l2);
//

        String str = redisTemplate.opsForValue().get("city");




        System.out.println(" =============== ShowRedis =============== ");
        System.out.println(" str :::: " +  str);
        return str;
    }



}
