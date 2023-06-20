package me.kktrkkt.springdata.spring_data_common.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SampleEntityRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @Rollback(value = false) // @DataJpaTest의 @Transactional 때문에 롤백되므로 롤백을 안하려면 명시해줘야한다
    public void crudRepository() {
        // create test
        Post post = new Post();
        post.setTitle("post");
        assertNull(post.getId());

        Post savePost = postRepository.save(post);

        Assertions.assertNotNull(savePost.getId());
        // create test

        // read test
        List<Post> all = postRepository.findAll();
        assertEquals(1, all.size());
        assertTrue(all.contains(savePost));

        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
        assertEquals(1, page.getTotalElements());
        assertEquals(0, page.getNumber());
        assertEquals(10, page.getSize());
        assertEquals(1, page.getNumberOfElements());
        // read test

        // update test
        savePost.setTitle("post2");
        Optional<Post> newPost = postRepository.findById(savePost.getId());
        newPost.ifPresent(x->assertEquals("post2", x.getTitle()));
        // update test

        // delete test
        postRepository.delete(savePost);
        List<Post> all1 = postRepository.findAll();
        assertEquals(0, all1.size());
        // delete test
    }
}