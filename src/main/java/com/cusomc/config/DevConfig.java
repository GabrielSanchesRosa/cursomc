package com.cusomc.config;

import com.cusomc.services.DBService;
import com.cusomc.services.EmailService;
import com.cusomc.services.SmtpEmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        if (!"create".equals(strategy)) {
            return false;
        }

        dbService.instantiateTestDatabase();

        return true;
    }

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}
