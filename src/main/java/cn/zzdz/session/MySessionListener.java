package cn.zzdz.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@Component
public class MySessionListener implements HttpSessionListener {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("xiaol"+se.getSession().getAttribute("username"));
        //redisTemplate.delete(se.getSession().getAttribute("username"));
    }
}
