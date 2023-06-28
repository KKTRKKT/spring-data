package me.kktrkkt.springdata.spring_data_common.custom_repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomPostRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CustomPostRepository postRepository;

    @Test
    public void findByMyPost() {
        Account account1 = persistAccount("account1");
        Account account2 = persistAccount("account2");

        persistPost("post1", account1);
        persistPost("post2", account1);
        persistPost("post3", account2);

        List<Post> myPosts1 = postRepository.findByMyPost(account1);
        assertEquals(2, myPosts1.size());
        List<Post> myPosts2 = postRepository.findByMyPost(account2);
        assertEquals(1, myPosts2.size());
    }

    @Test
    void delete() {
        Post post = persistPost("post", null);
        postRepository.delete(post);
        Post findPost = entityManager.find(Post.class, post.getId());
        assertNull(findPost);
    }

    private Post persistPost(String title, Account account) {
        Post post = new Post();
        post.setTitle(title);
        post.setAccount(account);
        entityManager.persist(post);
        return post;
    }

    private Account persistAccount(String username) {
        Account account = new Account();
        account.setUsername(username);
        entityManager.persist(account);
        return account;
    }
}