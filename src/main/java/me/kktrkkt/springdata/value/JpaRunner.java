package me.kktrkkt.springdata.value;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final SampleEntity sampleEntity = new SampleEntity();
        final Address address = Address.builder()
                .city("city")
                .state("state")
                .street("street")
                .zipCode("zipCode")
                .build();
        sampleEntity.setAddress(address);

        entityManager.persist(sampleEntity);
    }
}
