package br.com.davimc.todo.config;

import br.com.davimc.todo.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {


    @Autowired
    private DBService dbService;

    @Bean
    public boolean instanciateDatabase() throws ParseException {
        dbService.instantiateDatabase();
        return true;
    }

    /*@Bean
    public EmailService emailService() {
        return new MockMailService();
    }*/
}
