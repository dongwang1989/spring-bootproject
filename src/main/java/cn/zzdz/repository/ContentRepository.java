package cn.zzdz.repository;

import cn.zzdz.interfaces.service.IUserService;
import cn.zzdz.service.impl.AuthorityImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

public class ContentRepository implements SecurityContextRepository {

	@Autowired
	private IUserService userService;

	@Override
	@Transactional
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		System.out.println("ContentRepository");
		HttpSession session = requestResponseHolder.getRequest().getSession();
		SecurityContext getcontext;
		if (session == null || session.getAttribute("username") == null) {
			//System.out.println("123");
			getcontext = generateNewContext();
		} else {
			//System.out.println("333");
			// Authenticatio 令牌存信息用
			// Collections.emptyList();//kong list readonly not addd yanjinxiefa
			// Collections.unmodifiableList(list)//set readonly not change quanjuyingyong
			// userService
			String username = session.getAttribute("username").toString();
			Set<String> set = userService.cafindUserInfoByuser(username);
			Set<AuthorityImpl> permissions = set.stream().map(auth -> new AuthorityImpl(auth))
					.collect(Collectors.toSet());
			getcontext = generateNewContext();
			getcontext.setAuthentication(
					new UsernamePasswordAuthenticationToken(session.getAttribute("username"), "", permissions));
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
