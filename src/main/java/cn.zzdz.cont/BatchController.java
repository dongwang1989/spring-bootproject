package cn.zzdz.cont;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class BatchController {
//    //每2秒钟执行一次
    //@Scheduled(cron = "*/2 * * * * ?")n
    public void test(){
        System.out.println ("Time: ");
    }
}
