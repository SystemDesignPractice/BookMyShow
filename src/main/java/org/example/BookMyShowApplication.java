package org.example;


import org.example.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    InitService initService;

    public static void main(String[] args){
        SpringApplication.run(BookMyShowApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        initService.initialize();
    }

}