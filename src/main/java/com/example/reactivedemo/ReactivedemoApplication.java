package com.example.reactivedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactivedemoApplication /*implements CommandLineRunner*/ {



	public static void main(String[] args) {
		SpringApplication.run(ReactivedemoApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {

		userRepository.save(new User(1,"hari"));
		userRepository.save(new User(2,"aishu"));

		System.out.println("User found with findAll():");
		System.out.println("-------------------------------");

		for (User user : userRepository.findAll()) {
			System.out.println(user);
		}

		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('hari'):");
		System.out.println("--------------------------------");
		System.out.println(userRepository.findByName("hari"));

	}*/
}