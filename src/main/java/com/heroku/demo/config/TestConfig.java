package com.heroku.demo.config;

import com.heroku.demo.model.DBService;
import com.heroku.demo.service.EmailService;
import com.heroku.demo.service.MockEmailService;
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
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }

    /*
     * Injetado na classe PedidoService
     */
    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }
}