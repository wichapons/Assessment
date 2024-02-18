package com.kbtg.bootcamp.posttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PosttestApplication {

	public static void main(String[] args) {
		//Dotenv dotenv = Dotenv.configure().load();
		//String databaseUrl = dotenv.get("DATABASE_URL");
		//System.setProperty("spring.datasource.url", databaseUrl);
		SpringApplication.run(PosttestApplication.class, args);
	}

}
