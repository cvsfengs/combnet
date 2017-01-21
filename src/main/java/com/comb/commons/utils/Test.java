package com.comb.commons.utils;

import com.comb.commons.utils.spring.SpringUtil;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by Administrator on 2016/10/17.
 */
public class Test {

    public static void main(String[] args) {

        RedisTemplate redisTemplate = SpringUtil.getApplicationContext().getBean("redisTemplate", RedisTemplate.class);

        System.out.println(redisTemplate);
    }

}
