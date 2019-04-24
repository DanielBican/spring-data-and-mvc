package com.example.demo.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring Data JPA focuses on using JPA to store data in a relational database. Its most compelling
 * feature is the ability to create repository implementations automatically, at runtime, from a
 * repository interface.
 *
 * By default, Spring Boot will enable JPA repository support and look in the package (and its subpackages)
 * where @SpringBootApplication is located. If your configuration has JPA repository interface definitions
 * located in a package not visible, you can point out alternate packages using @EnableJpaRepositories and
 * its type-safe basePackageClasses=MyRepository.class parameter.
 */
@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a couple of users
			repository.save(new User("Jack", "Bauer"));
			repository.save(new User("Chloe", "O'Brian"));
			repository.save(new User("Kim", "Bauer"));
			repository.save(new User("David", "Palmer"));
			repository.save(new User("Michelle", "Dessler"));

			// fetch all users
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			// fetch an individual user by ID
			repository.findById(1L)
					.ifPresent(user -> {
						log.info("User found with findById(1L):");
						log.info("--------------------------------");
						log.info(user.toString());
						log.info("");
					});

			// fetch users by last name
			log.info("User found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}

}
