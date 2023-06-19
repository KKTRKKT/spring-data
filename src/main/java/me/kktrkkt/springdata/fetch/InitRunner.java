package me.kktrkkt.springdata.fetch;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Order(0)
@Component
public class InitRunner implements ApplicationRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if(entityManager.find(Post.class, 1L) != null){
            return;
        }

        final Post post = new Post();
        post.setTitle("post");

        final Comment comment1 = new Comment();
        final Comment comment2 = new Comment();

        comment1.setComment("c1");
        comment1.setPost(post);
        comment2.setComment("c2");
        comment2.setPost(post);

        entityManager.persist(post);
        entityManager.persist(comment1);
        entityManager.persist(comment2);
    }
}
