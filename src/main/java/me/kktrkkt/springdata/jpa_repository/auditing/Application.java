package me.kktrkkt.springdata.jpa_repository.auditing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "accountAuditorAware")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
