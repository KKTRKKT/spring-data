package me.kktrkkt.springdata.spring_data_common.repositoryInterface;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Order(0)
    @Test
    @Rollback(value = false)
    void save() {
        final Post post = new Post();
        post.setTitle("post");

        final Post save = postRepository.save(post);
        assertNotNull(save);
        assertEquals("post", save.getTitle());
    }

    @Order(1)
    @Test
    void findAll() {
        final List<Post> all = postRepository.findAll();
        assertEquals(1, all.size());
    }
}