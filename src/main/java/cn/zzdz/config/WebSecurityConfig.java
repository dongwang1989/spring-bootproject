package cn.zzdz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.SecurityContextRepository;

import cn.zzdz.repository.ContentRepository;


@Configuration
@EnableWebSecurity // 代理 不可能 weishenme 优先于aop 编译 运行时 为什么spring spring的拦截器是个什么
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("WebSecurityConfig");
		http.securityContext().securityContextRepository(createsecurity()).and().authorizeRequests()
				.antMatchers("/", "/whoim2", "/hello/{param}", "/login", "/whoim", "/exception/{param}",
						"/GET/environment", "/ha", "/a.html", "/new/**", "/denglu","/cas/**")
				.permitAll().anyRequest().authenticated().and().csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {// 如果是完全不受限制用这个，连解析都不解析，上面那个会做安全验证但是检查完不做限制

		web.ignoring().antMatchers("/whoim2", "/favicon.ico", "/webjars/**", "/swagger-resources/**",
				"/swagger-ui.html", "2/api-docs/**", "/GET/environment", "/ha", "/a.html", "/static/**", "/new/**",
				"/denglu","/exception/{param}","/test/**");
		// "/cas/**", "/denglu", "/police/**", "/car/**", "/carin/**", "/carfin/**"
	}

	@Bean
	public SecurityContextRepository createsecurity() {
		return new ContentRepository();
	}
		String ng="";
	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.authenticationProvider(provider);
	// }
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.authenticationProvider(provider); }
	 */

}
