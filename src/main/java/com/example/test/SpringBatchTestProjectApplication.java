package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.test.respository.SkuRepository;
//@EnableScheduling
@SpringBootApplication
public class SpringBatchTestProjectApplication {

	@Autowired
	public SkuRepository skuRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchTestProjectApplication.class, args);
	}

}
