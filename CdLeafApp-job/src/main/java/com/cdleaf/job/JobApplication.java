package com.cdleaf.job;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JobApplication {
    public static void main(String[] args) {
        System.out.println("SpringBootApplication - JobApplication ...... ");

        ApplicationContext ctx = SpringApplication.run(JobApplication.class, args);


        System.out.println("Job Application - Started ! ");
    }
}
