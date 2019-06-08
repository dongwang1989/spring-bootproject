package cn.zzdz.aspect;

import java.util.Collection;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cn.zzdz.enums.ErrorMessage;
import cn.zzdz.error.Error;
import cn.zzdz.permission.IPermission;

@Component
@Aspect
@Order(1)
public class PermissionAspect {


	/** 方法上注解情形 */
	@Pointcut(" @annotation(cn.zzdz.permission.IPermission)")
	public void aspect() {
	}

	@Before("aspect() && @annotation(permission)")
	public void getmethod(JoinPoint point, IPermission permission) throws Exception {
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		// 进行权限判断
		boolean isEquals = false;

		String permissionName = permission.value();
		if (authorities.stream().anyMatch(ga -> ga.getAuthority().equals(permissionName))) {
			isEquals = true;
		}
		if (isEquals == false) {
			throw new Error(ErrorMessage.POWER_NOTENOUGH, "sorry");
		}
	}


}
