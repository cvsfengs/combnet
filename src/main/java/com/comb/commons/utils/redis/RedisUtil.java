package com.comb.commons.utils.redis;

import com.comb.commons.utils.MarkInterface;
import com.comb.commons.utils.spring.SpringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by ycfeng on 2016/7/27.
 * redis 缓存工具类
 */
public class RedisUtil implements MarkInterface {

    private static RedisTemplate template ;

    static {
        template = SpringUtil.getApplicationContext().getBean("redisTemplate", RedisTemplate.class);
    }

    private RedisUtil() {}

    public static boolean set(String key,Object values){
        if(StringUtils.isBlank(key)||values==null){
            return false ;
        }
        try {
            template.opsForValue().set(key, values);
        } catch (Exception e) {
            System.out.println(e);
            return false ;
        }
        return true ;
    }
    /*public static Boolean set(final  String key,final Object values,final long liveTime){
        if (StringUtils.isBlank(key) || values == null) {
            return false;
        }
        try {
            template.execute(new RedisCallback() {
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.set(key.getBytes(),values.toString().getBytes());
                    if (liveTime > 0) {
                        connection.expire(key.getBytes(), liveTime);
                    }
                    return 1L;
                }
            });
        } catch (Exception e) {
            return false;
        }

        return true ;
    }*/
    public static <T> T get(String key,Class<T> clazz){
        if(StringUtils.isBlank(key)||clazz==null){
            return null;
        }
        return (T) get(key);
    }

    public static Object get(String key){
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return template.opsForValue().get(key);
    }
    public static boolean remove(final String... key){
        try {
            if(key.length==0){
                return false ;
            }
            RedisCallback callback = new RedisCallback() {
                @Override
                public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    int leg = key.length ;
                    for(int i=0;i<leg;i++){
                       redisConnection.del(key[i].getBytes());
                    }
                    return null ;
                };
            };
            template.execute(callback);
            return true ;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Boolean exists(final String key){
        if(StringUtils.isBlank(key)){
            return false ;
        }
        RedisCallback callback = new RedisCallback() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.exists(key.getBytes());
            };
        };
       return (Boolean)template.execute(callback);
    };
    public static boolean flushDB(){
        RedisCallback callback = new RedisCallback() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.flushDb();
                return true;
            };
        };
        return (Boolean)template.execute(callback) ;
    };
    public static boolean update(String key,Object values){
        return false ;
    }

    public static void main(String[] args) {


        System.out.println(String.valueOf(RedisUtil.set("hello","nss")));

//        String demo = String.valueOf(RedisUtil.get("demo"));
//        System.out.println(demo);
//        Boolean exists = RedisUtil.flushDB();
//        System.out.println(exists);

    }

}

