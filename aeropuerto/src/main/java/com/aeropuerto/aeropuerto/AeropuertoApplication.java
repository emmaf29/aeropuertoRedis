package com.aeropuerto.aeropuerto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AeropuertoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeropuertoApplication.class, args);
	}

}
