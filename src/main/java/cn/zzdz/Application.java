package cn.zzdz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

import cn.zzdz.config.WebMvcConfiguration;

@SpringBootApplication
@EnableCaching
@MapperScan(value="cn.zzdz.mapper")
public class Application extends WebMvcConfiguration {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}
}
