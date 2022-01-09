package com.upgrad;

import com.upgrad.movieapp.dao.CustomerDao;
import com.upgrad.movieapp.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class MovieappApplication {

	@Autowired
	CustomerDao customerDao;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);

		CustomerDao customerDao = context.getBean(CustomerDao.class);
		/*System.out.println(context.getBeanDefinitionCount());
		System.out.println(Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList()).contains("myService"));
		System.out.println("Hello Team");*/

		Customer cust = new Customer();
		cust.setFirstName("Sourabh1");
		cust.setLastName("Sethi");
		cust.setPassword("********");
		cust.setUserName("sethi@gmail.com");

		System.out.println("Before Saving" + cust);
		Customer savedCustomer = customerDao.save(cust);
		System.out.println("After Saving : "+ savedCustomer);

	}

	@RequestMapping("/")
	public String greetStudents(){

		Customer customer = customerDao.findById(1);

		return "Hello " + customer.getUserName() + ", Welcome to Spring Boot...";
	}

}
