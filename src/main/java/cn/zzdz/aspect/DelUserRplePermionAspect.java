package cn.zzdz.aspect;

import cn.zzdz.annotation.IDelUserRplePermion;
import cn.zzdz.interfaces.service.ILogin;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DelUserRplePermionAspect {
    /**
     * 方法上注解情形
     */
    @Pointcut(" @annotation(cn.zzdz.annotation.IDelUserRplePermion)")
    public void aspect() {
    }

    @Autowired
    private ILogin loginErvice;

    @Before("aspect() && @annotation(delUserRplePermion)")
    public void getmethod(JoinPoint point, IDelUserRplePermion delUserRplePermion) throws Exception {
        if (!delUserRplePermion.value().equals("")) {
            String delname = delUserRplePermion.value();
            if (delname.equals("UserRoleAll")) {
                loginErvice.delUserRoleAll();
            } else if (delname.equals("RolePerAll")) {
                loginErvice.delRolePerAll();
            } else {
                loginErvice.delCacheAll();
            }
        }
    }
}
