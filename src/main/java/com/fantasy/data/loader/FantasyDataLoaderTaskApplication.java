package com.fantasy.data.loader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@EnableTask
@SpringBootApplication
public class FantasyDataLoaderTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(FantasyDataLoaderTaskApplication.class, args);
    }
}