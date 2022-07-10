package io.github.margato.vs.validatevote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ValidateVoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidateVoteApplication.class, args);
    }

}
