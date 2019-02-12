package cn.zzdz.repository;

import cn.zzdz.interfaces.service.IUserService;
import cn.zzdz.service.impl.AuthorityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;
import java.lang.String;

public class ContentRepository implements SecurityContextRepository {

	@Autowired
	private IUserService userService;
	@Autowired
	private RedisTemplate<Object,Object> redisTemplate;

	@Override
	@Transactional
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		System.out.println("ContentRepository");
		HttpSession session = requestResponseHolder.getRequest().getSession();
		SecurityContext getcontext;
		if (session == null || session.getAttribute(session.getId()) == null) {
			getcontext = generateNewContext();
		} else {
			//System.out.println("333");
			// Authenticatio 令牌存信息用
			// Collections.emptyList();//kong list readonly not addd yanjinxiefa
			// Collections.unmodifiableList(list)//set readonly not change quanjuyingyong
			// userService
			String userid = session.getAttribute(session.getId()).toString();
			Set<Object> set =redisTemplate.opsForSet().members(userid);
			/* Set<String> set = redisTemplate//userService.cafindUserInfoByuser(username); */
			Set<AuthorityImpl> permissions = set.stream().map(auth -> new AuthorityImpl(auth))
					.collect(Collectors.toSet());
			getcontext = generateNewContext();
			getcontext.setAuthentication(
					new UsernamePasswordAuthenticationToken(session.getAttribute(session.getId()), "", permissions));
		}
		return getcontext;
	}

	@Override
	public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
	}

	@Override
	public boolean containsContext(HttpServletRequest request) {
		return true;
	}

	protected SecurityContext generateNewContext() {
		return SecurityContextHolder.createEmptyContext();
	}
}
