package com.upgrad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);
		/*System.out.println(context.getBeanDefinitionCount());
		System.out.println(Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList()).contains("myService"));
		System.out.println("Hello Team");*/
	}

	@RequestMapping("/")
	public String greetStudents(){
		return "Hello Team! Welcome to Spring Boot...";
	}

}
