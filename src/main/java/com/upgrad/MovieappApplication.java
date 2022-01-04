package com.upgrad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieappApplication.class, args);
		System.out.println("Hello Team");
	}

	@RequestMapping("/")
	public String greetStudents(){
		return "Hello Team! Welcome to Spring Boot...";
	}

}