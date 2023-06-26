package me.kktrkkt.springdata.spring_data_common.query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    private final String spring_data = "Spring Data";
    private final String spring_common = "Spring Common";
    private final String data_jpa = "Data JPA";
    @Autowired
    private CommentRepository commentRepository;

    @BeforeEach
    public void beforeEach() {
        Comment comment1 = new Comment();
        comment1.setComment(spring_data);
        comment1.setLikeCount(3);

        Comment comment2 = new Comment();
        comment2.setComment(data_jpa);
        comment2.setLikeCount(1);

        Comment comment3 = new Comment();
        comment3.setComment(spring_common);
        comment3.setLikeCount(2);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
    }

    @Test
    void findByCommentContainsIgnoreCase() {
        List<Comment> spring = commentRepository.findByCommentContainsIgnoreCase("spring");
        assertEquals(2, spring.size());
    }

    @Test
    void findByOrderByLikeCountDesc() {
        List<Comment> coments = commentRepository.findByOrderByLikeCountDesc();
        assertEquals(spring_data, coments.get(0).getComment());
        assertEquals(spring_common, coments.get(1).getComment());
        assertEquals(data_jpa, coments.get(2).getComment());
    }

    @Test
    void findByCommentContainsIgnoreCasePage() {
        PageRequest of = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));
        Page<Comment> spring = commentRepository.findByCommentContainsIgnoreCase("spring", of);
        assertEquals(2, spring.getTotalElements());
        assertEquals(spring_data, spring.getContent().get(0).getComment());
        assertEquals(spring_common, spring.getContent().get(1).getComment());

    }
}