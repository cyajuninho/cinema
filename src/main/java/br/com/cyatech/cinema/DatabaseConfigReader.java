package br.com.cyatech.cinema;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfigReader {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public void readConfig(String filePath) {
        Properties prop = new Properties();
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            prop.load(inputStream);
            System.out.println("Arquivo properties encontrado");
            dbUrl = prop.getProperty("url");
            dbUser = prop.getProperty("user");
            dbPassword = prop.getProperty("password");
        } catch (IOException e) {
            System.out.println("Arquivo properties não encontrado");
            e.printStackTrace();
        }
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}
