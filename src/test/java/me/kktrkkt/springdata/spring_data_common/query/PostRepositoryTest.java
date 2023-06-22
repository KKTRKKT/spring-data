package me.kktrkkt.springdata.spring_data_common.query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    public void beforeEach() {
        Post post1 = new Post();
        post1.setTitle("post1");

        Post post2 = new Post();
        post2.setTitle("post2");

        Post post3 = new Post();
        post3.setTitle("post3");

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
    }

    @Test
    void findByTitleContains() {
        List<Post> post = postRepository.findByTitleContains("post");
        assertEquals(3, post.size());
    }

    @Test
    void jpqlFindByTitleContains() {
        List<Post> post = postRepository.jpqlFindByTitleContains("post");
        assertEquals(3, post.size());
    }

    }
}