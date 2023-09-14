package com.example.myazureapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.myazureapp.repository")
public class MyazureappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyazureappApplication.class, args);
	}

}
