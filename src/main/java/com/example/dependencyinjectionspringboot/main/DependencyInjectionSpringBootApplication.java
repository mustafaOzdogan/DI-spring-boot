package com.example.dependencyinjectionspringboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.example.dependencyinjectionspringboot.service")
public class DependencyInjectionSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionSpringBootApplication.class, args);
	}

}
