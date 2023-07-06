package me.kktrkkt.springdata.specification;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository posts;

    @Test
    void findAll() {
        posts.findAll(PostsSpec.isBest().or(PostsSpec.isPublic()));
    }
}