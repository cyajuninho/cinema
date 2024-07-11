package br.com.cyatech.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class CinemaAppConfig {

    public Properties getDbProperties() throws IOException {

        // Arquivo de configuração
        Properties prop = new Properties();
        String caminho  = "c://applications_properties//cinema2_dev.properties.txt";
        File arquivo = new File(caminho);

        // Verifica se o arquivo existe
        if (!arquivo.exists()) {
            throw new IOException("Arquivo de configuração não encontrado em: " + caminho);
        }

        // Carrega as propriedades
        try (FileInputStream input = new FileInputStream(arquivo)) {
            prop.load(input);
        } catch (IOException e) {
            throw new IOException("Erro ao carregar as propriedades do arquivo: " + caminho, e);
        }
        return prop;
    }

    @Bean
    public DataSource dataSource() throws IOException {

        // Carrega propriedades do arquivo de configuração
        Properties prop = getDbProperties();

        // Dados do banco
        String url = "jdbc:mysql://"+prop.getProperty("url")+"/"+prop.getProperty("database");
        String user = prop.getProperty("username");
        String password = prop.getProperty("password");

        // Cria o datasource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
