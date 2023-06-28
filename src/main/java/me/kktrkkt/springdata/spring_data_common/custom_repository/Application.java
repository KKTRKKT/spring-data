package me.kktrkkt.springdata.spring_data_common.custom_repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryImplementationPostfix = "Default")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
