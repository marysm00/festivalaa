package com.faa.faa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.faa.faa.services.artista_service;

@SpringBootApplication()
public class FestAAApplication extends SpringBootServletInitializer {
	@Autowired
	static artista_service art;

	public static void main(String[] args) {

		SpringApplication.run(FestAAApplication.class, args);

	}

}
