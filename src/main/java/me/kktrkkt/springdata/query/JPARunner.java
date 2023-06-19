package me.kktrkkt.springdata.query;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Order(1)
@Component
@Transactional
public class JPARunner implements ApplicationRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // JPQL(HQL)
        // SQL과 다르게 엔티티 중심으로 쿼리를 작성
        // 문자열기반으로 타입세이프하지 않다
        final TypedQuery<SampleEntity> query = entityManager.
                createQuery("SELECT se FROM SampleEntity as se", SampleEntity.class);
        System.out.println("=======================JPQUL(HQL)==============================");
        query.getResultStream().forEach(System.out::println);

        // Criteria 타입세이프한 쿼리
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<SampleEntity> criteriaQuery = criteriaBuilder.createQuery(SampleEntity.class);
        final Root<SampleEntity> root = criteriaQuery.from(SampleEntity.class);
        criteriaQuery.select(root);
        System.out.println("=======================Criteria==============================");
        entityManager.createQuery(criteriaQuery)
                .getResultStream().forEach(System.out::println);

        // SQL
        System.out.println("=======================Native Query==============================");
        entityManager.createNativeQuery("select * from sample_entity", SampleEntity.class)
                .getResultStream().forEach(System.out::println);
    }
}
