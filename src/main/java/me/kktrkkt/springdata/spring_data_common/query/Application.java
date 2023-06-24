package me.kktrkkt.springdata.spring_data_common.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@SpringBootApplication
// 쿼리 생성 전략을 변경하려면 queryLookupStrategy 옵션을 설정하면된다.
@EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
