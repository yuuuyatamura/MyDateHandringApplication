package com.example.DateHandring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages={"com"})
@Configuration
@ComponentScan
public class MyDateHandringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDateHandringProjectApplication.class, args);

	}

}
