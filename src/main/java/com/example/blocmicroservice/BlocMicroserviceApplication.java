package com.example.blocmicroservice;

import com.example.blocmicroservice.Repositories.BlocRepository;
import com.example.blocmicroservice.entities.Bloc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = "com.example.bloc.entities")
public class BlocMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlocMicroserviceApplication.class, args);
	}
	@Autowired
	private BlocRepository repository;

	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save
			repository.save(new Bloc("Mariem", 5));
			repository.save(new Bloc("Sarra", 10));
			repository.save(new Bloc("Mohamed", 55));
			// fetch
			repository.findAll().forEach(System.out::println);
		};
	}
}
