package me.kktrkkt.springdata.spring_data_common.custom_jpa_repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MyRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void contains() {
        Post post = new Post();
        assertFalse(postRepository.contains(post));
        postRepository.save(post);
        assertTrue(postRepository.contains(post));
    }
}