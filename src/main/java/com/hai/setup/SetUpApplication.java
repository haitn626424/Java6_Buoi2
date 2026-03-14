package com.hai.setup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class SetUpApplication {

    public static void main(String[] args) {

        SpringApplication.run(SetUpApplication.class, args);
        System.out.println("Running...");
    }

}
