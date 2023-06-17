package me.kktrkkt.springdata.cascade;

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
        Post post = new Post();
        post.setTitle("kktrkkt");

        Comment comment1 = new Comment();
        comment1.setComment("1");

        Comment comment2 = new Comment();
        comment2.setComment("2");

        post.getCommentList().add(comment1);
        post.getCommentList().add(comment2);

        // cascade를 설정하지 않으면 comment는 저장되지 않는다. 즉 엔티티 상태를 전파해주는 옵션
        entityManager.persist(post);
    }
}
