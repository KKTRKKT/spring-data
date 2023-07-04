package me.kktrkkt.springdata.jpa_repository.query_and_sort;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void findByTitle() {
        Post post = new Post();
        post.setTitle("spring");
        postRepository.save(post);

        // Sort는 쿼리 안에서 사용한 프로퍼티 또는 alias만 정렬할 수 있다
        postRepository.findByTitle("spring", Sort.by("title"));
        postRepository.findByTitle("spring", Sort.by("pTitle"));
        assertThrows(DataAccessException.class, ()->postRepository.findByTitle("spring", Sort.by("LENGTH(title)")));

        // db 함수를 사용할 경우 JpaSort.unsafe를 통해 호출한다
        postRepository.findByTitle("spring", JpaSort.unsafe("LENGTH(title)"));
    }
}