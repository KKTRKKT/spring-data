package me.kktrkkt.springdata.life_cycle;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EntityLifeCycleTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Rollback(value = false)
    void lifeCycleTest() {
        Post post = new Post();
        post.setTitle("post");
        entityManager.persist(post);
        Post savedPost = entityManager.find(Post.class, post.getId());
        savedPost.setTitle("new Post");
        entityManager.remove(savedPost);
    }
}