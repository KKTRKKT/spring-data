package me.kktrkkt.springdata.spring_data_common.domain_event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(PostConfig.class)
class DomainEventTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void publish() {
        Post post = new Post();
        post.setTitle("title");
        postRepository.save(post.publish());
    }
}