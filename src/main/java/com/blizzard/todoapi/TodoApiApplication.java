package com.blizzard.todoapi;

import com.blizzard.todoapi.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TodoApiApplication {
	@Autowired
	ITodoRepository todoRepo;

	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}

}
