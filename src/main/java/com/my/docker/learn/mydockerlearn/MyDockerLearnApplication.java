package com.my.docker.learn.mydockerlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyDockerLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDockerLearnApplication.class, args);
    }


    @Autowired
    private Environment environment;

    @Value("${msg.suffix}")
    private String msgSuffix;

    @GetMapping("/greeting/{message}")
    public String getGreeting(@PathVariable String message) {

        String port = environment.getProperty("local.server.port");

        //CHANGE-KUBERNETES
        String host = environment.getProperty("HOSTNAME");
        String version = "v11";

        return "Hello " + message + " " + msgSuffix + " port: " + port + " " + version + " " + host;
    }
}
