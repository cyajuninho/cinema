package br.com.cyatech.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
@PropertySource("file:c:/applications_properties/cinema_dev.properties.txt")
public class CinemaApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

        SpringApplication.run(CinemaApplication.class, args);
	}

}
