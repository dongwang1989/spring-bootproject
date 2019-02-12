package cn.zzdz.config;

import cn.zzdz.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebMvcConfiguration implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
				.setCacheControl(CacheControl.maxAge(3650, TimeUnit.DAYS));
		registry.addResourceHandler("/swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html")
				.setCacheControl(CacheControl.maxAge(3650, TimeUnit.DAYS));
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
				.setCacheControl(CacheControl.maxAge(3650, TimeUnit.DAYS));
	}
	@Bean
	public HttpMessageConverter<String> responseBodyConverter(){
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(responseBodyConverter());
	}
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}


}
