package com.upgrad;

import com.upgrad.movieapp.dao.CustomerDao;
import com.upgrad.movieapp.dao.MovieDao;
import com.upgrad.movieapp.entities.Customer;
import com.upgrad.movieapp.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class MovieappApplication {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	MovieDao movieDao;

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
		customer.setFirstName("Lets test it");
		customerDao.update(customer);
		customer =  customerDao.findById(1);

		return "Hello " + customer + ", Welcome to Spring Boot...";
	}

	@RequestMapping("/movie")
	public String movieDetails(){

		Movie movie = new Movie();
		movie.setMovie_name("Avengers: Infinity War");
		movie.setMovie_desc("The Avengers should stop devil");
		movie.setRelease_date(LocalDate.of(2018,4,12));
		movie.setDuration(150);
		movie.setCover_photo_url("Cover Url");
		movie.setTrailer_url("Trailer Url");

		System.out.println("Before Saving" + movie);
		Movie savedMovie = movieDao.save(movie);

		// Search Movie;
		Movie retrievedMovie = movieDao.findById(savedMovie.getMovie_id()).orElse(null);

		movie.setDuration(250);
		Movie moviewUpdated = movieDao.save(movie);
		return "Hello Movie Id " + moviewUpdated.getMovie_id() + ", Welcome to Spring Boot... " + " Moview Duration " + moviewUpdated.getDuration();
	}

}
