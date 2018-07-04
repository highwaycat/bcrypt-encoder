package com.trantor.bcryptencoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BcryptEncoderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BcryptEncoderApplication.class, args);
    }
}
