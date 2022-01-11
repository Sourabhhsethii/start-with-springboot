package com.upgrad;

import com.upgrad.movieapp.dao.sql.hibernate.CustomerDao;
import com.upgrad.movieapp.dao.mongo.CustomerRepository;
import com.upgrad.movieapp.dao.sql.springorm.MovieDao;
import com.upgrad.movieapp.entities.sql.Customer;
import com.upgrad.movieapp.entities.mongo.CustomerMongoEnitity;
import com.upgrad.movieapp.entities.sql.Movie;
import com.upgrad.movieapp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@SpringBootApplication
public class MovieappApplication implements CommandLineRunner {

	@Autowired
	MovieService movieService;

	@Autowired
	CustomerDao customerDao;

	@Autowired
	MovieDao movieDao;

	@Autowired
	CustomerRepository customerRepository;

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
		movie.setMovieName("Avengers: Infinity War");
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

	@RequestMapping("/getAllMovies")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}

	@Override
	public void run(String... args) throws Exception {
		CustomerMongoEnitity customerMongoEnitity1 = new CustomerMongoEnitity(1,
				"Sourabh","Sethi","ssethi","test",
				LocalDateTime.of(1995,12,07,12,00));

		CustomerMongoEnitity customerMongoEnitity2 = new CustomerMongoEnitity(2,
				"Shrey","Sethi","ssethi2","test",
				LocalDateTime.of(1992,12,07,12,00));

		CustomerMongoEnitity customerMongoEnitity3 = new CustomerMongoEnitity(3,
				"Rakesh","Roshan","rrroshan","test",
				LocalDateTime.of(1985,12,07,12,00));

		/**
		 * Save the data in Mongodb.
		 */

		customerRepository.save(customerMongoEnitity1);
		customerRepository.save(customerMongoEnitity2);
		customerRepository.save(customerMongoEnitity3);

		/**
		 * Fetching the data from Mongodb
		 */
		for (CustomerMongoEnitity customerMongoEnitity: customerRepository.findAll()){
			System.out.println(customerMongoEnitity);
		}

		/**
		 * Find the record
		 */
		System.out.println(customerRepository.findByFirstName("Sourabh"));

		/**
		 * Fecth the result based on last Name.
		 */
		System.out.println(customerRepository.findByLastName("Sethi"));
	}
}
