package me.kktrkkt.springdata.jpa_repository.repository_annotation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void wrapExceptionTest() {
        Post post = new Post();
        // @Repository를 사용하면 SQLException 또는 JPA 관련 예외를 DataAccessException으로 감싸준다
        assertThrows(DataAccessException.class, ()->postRepository.save(post));
        postRepository.findAll();
    }
}