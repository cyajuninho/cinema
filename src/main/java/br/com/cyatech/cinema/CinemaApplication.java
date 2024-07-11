package br.com.cyatech.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args) throws SQLException {

		DatabaseConfigReader reader = new DatabaseConfigReader();
		reader.readConfig("c:\\applications_properties\\cinema_dev.properties.txt");


		try {
			Connection connection = DriverManager.getConnection(reader.getDbUrl(), reader.getDbUser(), reader.getDbPassword());
			System.out.println("Conexão estabelecida? " + !connection.isClosed());
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados");
			e.printStackTrace();
		}
        SpringApplication.run(CinemaApplication.class, args);
	}

}
