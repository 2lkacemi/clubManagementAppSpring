package com.example.club_HR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DemoApplication implements CommandLineRunner {//cette implementation de cette interface permet de tester dans la meme class et obligne de redefinir la methode run de cette interface

    private static Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    public void run(String... arg0) throws Exception {


    }

}
