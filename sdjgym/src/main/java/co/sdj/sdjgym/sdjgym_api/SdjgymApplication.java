package co.sdj.sdjgym.sdjgym_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.sdj.sdjgym.controller"})
public class SdjgymApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdjgymApplication.class, args);
	}

}
