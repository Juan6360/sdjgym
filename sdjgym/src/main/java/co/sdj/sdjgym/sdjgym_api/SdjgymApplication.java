package co.sdj.sdjgym.sdjgym_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = {"co.sdj.sdjgym.controller"})
public class SdjgymApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdjgymApplication.class, args);
	}
	
	public class WebConfig implements WebMvcConfigurer{
		
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("http://localhost:8081")
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowedHeaders("*").allowCredentials(true);
		}
		
	}

}
