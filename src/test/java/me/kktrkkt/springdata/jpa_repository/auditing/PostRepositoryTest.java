package me.kktrkkt.springdata.jpa_repository.auditing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @Rollback(value = false)
    void save() {
        Post post = new Post();
        post.setTitle("post");
        postRepository.save(post);
    }
}