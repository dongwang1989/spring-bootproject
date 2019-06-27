package cn.zzdz.aspect;

import cn.zzdz.annotation.IDelRolePermion;
import cn.zzdz.annotation.IDelUseridRole;
import cn.zzdz.domain.Syrole;
import cn.zzdz.domain.SysUser;
import cn.zzdz.interfaces.service.IPermionRole;
import cn.zzdz.interfaces.service.IUserRole;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class DelRolePermionAspect {
    /**
     * 方法上注解情形
     */
    @Pointcut(" @annotation(cn.zzdz.annotation.IDelRolePermion)")
    public void aspect() {
    }

    @Autowired
    private IUserRole userRoleervice;
    @Autowired
    private IPermionRole permionRoleervice;

    @Before("aspect() && @annotation(delRolePermion)")
    public void getmethod(JoinPoint point, IDelRolePermion delRolePermion) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String nm = delRolePermion.value();
        Integer roleid;
        if (nm.equals("entity")) {
            Syrole uer = (Syrole) point.getArgs()[0];
            roleid=uer.getRoleid();
        } else {
            roleid = Integer.parseInt(request.getParameter("id"));
        }
        permionRoleervice.deluserpermion(roleid);
    }
}
