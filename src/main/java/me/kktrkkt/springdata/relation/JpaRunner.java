package me.kktrkkt.springdata.relation;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional // 트랙잭션 범위를 설정한다. (메소드, 클래스)
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager; // JPA의 핵심 클래스로 ORM을 구현해 객체를 영속화 시켜준다

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Account account = new Account();
        account.setUsername("kktrkkt");
        account.setPassword("pass");
        account.setPassword("jpa");

        final Study study = new Study();
        study.setName("Spring Data JPA");

//        account.getStudies().add(study); // 종속 관계가 관계를 정의하면 안됨
//        study.setOwner(account); // 주인 관계에서 정의할때 DB 영속화

        account.addStudy(study);

        entityManager.persist(study);
        entityManager.persist(account);
    }
}
