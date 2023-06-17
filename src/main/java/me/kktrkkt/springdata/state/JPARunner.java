package me.kktrkkt.springdata.state;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class JPARunner implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        // sampleEntity는 transient 상태(JPA가 모르는 상태)
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setColumn("column1");
        // persist 상태 (JPA가 해당 엔티티를 관리하고 있는 상태)
        entityManager.persist(sampleEntity);
        // 관리상태에서는 1차적 캐싱, lazy loding 지원,
        // 값이 변경되면 자동으로 update, 하지만 초기값과 같으면 변경하지 않음(dirty checking, write behind)
        SampleEntity sampleEntity1 = entityManager.find(SampleEntity.class, sampleEntity.getId());
        System.out.println(sampleEntity1.getId());
        sampleEntity.setColumn("column2");
        sampleEntity.setColumn("column1");

        // transaction이 끝나면 detached 상태(JPA가 관리하지 않음)
        // update 등으로 다시 persist 상태로 만들어 줄 수 있음
    }
}
