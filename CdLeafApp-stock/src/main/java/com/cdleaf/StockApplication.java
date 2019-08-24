package com.cdleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;


@SpringBootApplication
@EnableJpaRepositories
public class StockApplication {
    private static Logger logger = LoggerFactory.getLogger(StockApplication.class);


    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(StockApplication.class, args);


        logger.info(" ---------------------------  Stock Application Started ---------------");
        String[] beanNames = ctx.getBeanDefinitionNames();

        Arrays.sort(beanNames);

        for (String beanName : beanNames) {
//            System.out.println(beanName);

            logger.trace(beanName);
        }

        logger.error(" Spring Boot Application start ...... Done!");
    }
}
