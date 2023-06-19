package me.kktrkkt.springdata.query;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Order(0)
@Component
@Transactional
public class InitRunner implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        entityManager.persist(new SampleEntity());
        entityManager.persist(new SampleEntity());
        entityManager.persist(new SampleEntity());
        entityManager.persist(new SampleEntity());
        entityManager.persist(new SampleEntity());
    }
}
