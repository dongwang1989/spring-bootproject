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
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.lang.String;

public class ContentRepository implements SecurityContextRepository {

	@Autowired
	private IUserService userService;
	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	@Override
	@Transactional
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {

		HttpSession session = requestResponseHolder.getRequest().getSession();

		SecurityContext getcontext;
		redisTemplate.opsForValue().get(session.getId().toString());
		Object userid =redisTemplate.opsForValue().get(session.getId().toString());
		if (session == null ||  userid== null) {
			System.out.println("ContentRepository1");
			getcontext = generateNewContext();
		} else {
			System.out.println("ContentRepository");
			//String userid =redisTemplate.opsForValue().get(session.getId()).toString();
			Set<String> set= userService.getPermions(userid.toString());
			//Set<Object> set =redisTemplate.opsForSet().members(userid);
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
