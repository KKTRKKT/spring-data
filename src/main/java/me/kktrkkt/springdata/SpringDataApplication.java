package me.kktrkkt.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// HibernateJpaAutoConfiguration을 통해 JPA 관련 빈들이 모두 등록된다
// spring.jpa.hibernate.ddl-auto 타입 create는 데이터는 모두 사라지지만 컬럼은 정확하게 매핑됨
// update는 데이터는 유지되지만 객체에서 속성이 삭제되도 컬럼은 삭제되도 삭제되지 않음
@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

}
