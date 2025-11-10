package com.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = "com.example")

@EntityScan(basePackages = "com.example.projects.entity") 

@EnableJpaRepositories(basePackages = "com.example.repository") 
public class JavaAssignmentApplication {
		
		@PostConstruct
	    public void init() {
	        System.out.println("Application Started.");
	    }

	    @PreDestroy
	    public void destroy() {
	        System.out.println("Application Destroyed.");
	    }
	    public static void main(String[] args) {
		SpringApplication.run(JavaAssignmentApplication.class, args);
	}

}
