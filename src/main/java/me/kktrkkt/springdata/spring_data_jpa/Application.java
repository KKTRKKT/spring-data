package me.kktrkkt.springdata.spring_data_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// spring boot에서 자동으로 설정해준다.
// @Configuration @EnableJpaRepositories JPARepository를 사용하기 위한 애노테이션
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
