package me.kktrkkt.springdata;

import org.hibernate.Session;
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

        entityManager.persist(account);

        // hibernate 모듈 이용가능
        final Session session = entityManager.unwrap(Session.class);
        account.setPassword("jpa");

        final Study study = new Study();
        study.setName("Spring Data JPA");
        study.setOwner(account);

        session.save(study);
        session.save(account);
    }
}
