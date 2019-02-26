package cn.zzdz.redismap;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @auther john
 * @date 2019/2/3
 *
 * redis 分布式锁  加锁与解密配套使用
 */
@Component
public class RedisLock {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     * @param key 锁唯一标志
     * @param timeout 超时时间
     * @return
     */
    public boolean lock(String key, long timeout){

        String value = String.valueOf(timeout + System.currentTimeMillis());
        if(stringRedisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }

        //判断锁超时,防止死锁
        String currentValue = (String)stringRedisTemplate.opsForValue().get(key);
        //如果锁过期
        if(!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()){
            //获取上一个锁的时间value
            String oldValue = (String) stringRedisTemplate.opsForValue().getAndSet(key,value);
            if(!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue) ){
                //校验是不是上个对应的商品时间戳,也是防止并发
                return true;
            }
        }
        return false;
    }
    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key,String value){
        try {
            String currentValue =  (String) stringRedisTemplate.opsForValue().get(key);
            if(!StringUtils.isEmpty(currentValue) && currentValue.equals(value) ){
                stringRedisTemplate.opsForValue().getOperations().delete(key);//删除key
            }
        } catch (Exception e) {
            //log.error("[Redis分布式锁] 解锁出现异常了，{}",e);
        }
    }
}


