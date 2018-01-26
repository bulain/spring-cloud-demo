package com.bulain.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

//@EnableZipkinStreamServer
@EnableZipkinServer
@EnableEurekaClient
@SpringBootApplication
public class ZiplinServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ZiplinServerApplication.class, args);
    }

    private static final ExecutorService executor = Executors.newFixedThreadPool(1);
    
    @Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.builder().datasource(datasource).executor(executor).build();
    }
    
}
