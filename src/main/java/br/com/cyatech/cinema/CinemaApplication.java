package br.com.cyatech.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args) {
		System.setProperty("spring.jpa.hibernate.ddl-auto", "update");

        SpringApplication.run(CinemaApplication.class, args);
	}
}
