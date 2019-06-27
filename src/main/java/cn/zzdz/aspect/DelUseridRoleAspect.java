package cn.zzdz.aspect;

import cn.zzdz.annotation.IDelUseridRole;
import cn.zzdz.domain.SysUser;
import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.error.Error;
import cn.zzdz.interfaces.service.ILogin;
import cn.zzdz.interfaces.service.IPermionRole;
import cn.zzdz.interfaces.service.IUserRole;
import cn.zzdz.permission.IPermission;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.codehaus.jettison.json.JSONObject;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Collection;

@Component
@Aspect
public class DelUseridRoleAspect {
    /**
     * 方法上注解情形
     */
    @Pointcut(" @annotation(cn.zzdz.annotation.IDelUseridRole)")
    public void aspect() {
    }

    @Autowired
    private IUserRole userRoleervice;

    @Before("aspect() && @annotation(useridRole)")
    public void getmethod(JoinPoint point, IDelUseridRole useridRole) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String nm = useridRole.value();

        Integer userid;
        if (nm.equals("entity")) {
            SysUser uer = (SysUser) point.getArgs()[0];
            userid=uer.getUserid();
        } else {
            userid = Integer.parseInt(request.getParameter("id"));
        }
        userRoleervice.delroleset(userid);
    }
}
