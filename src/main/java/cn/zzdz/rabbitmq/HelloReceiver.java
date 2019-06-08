package cn.zzdz.rabbitmq;

import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.error.Error;
import cn.zzdz.redismap.RedisLock;
import cn.zzdz.redismap.RedisUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    @Autowired
    private RedisLock redisLock;
    @Autowired
    private RedisUtils redisUtils;

    @RabbitHandler
    public void process(String hello) {
        //接受请求redis
        long time = System.currentTimeMillis() + 10000;
        if (!redisLock.lock("1", String.valueOf(time))) {
            //throw new Error(ErrorMessage.INCORRECT_PASSWORD, "locka");
        } else {
            //判断库存是否为0
            int count=Integer.parseInt(redisUtils.get("count"));
            if (count==0){
                throw new Error(ErrorMessage.INCORRECT_PASSWORD, "lockc");
            }
            else {
                redisUtils.set("count",String.valueOf(count-1),1);
            }
        }
        redisLock.unlock("1",String.valueOf(time));
        System.out.println("Receiver  : " + hello);
    }
}
