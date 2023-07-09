package me.kktrkkt.springdata.jpa_repository.specification;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository posts;

    @Test
    void findAll() {
        posts.findAll(PostsSpec.isBest().or(PostsSpec.isPublic()));
    }
}