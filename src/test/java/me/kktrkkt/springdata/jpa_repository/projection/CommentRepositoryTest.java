package me.kktrkkt.springdata.jpa_repository.projection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository comments;

    @BeforeEach
    public void beforeEach() {
        Comment comment = new Comment();
        comment.setComment("comment");
        comment.setUp(10);
        comment.setDown(1);
        comment.setBest(true);

        comments.save(comment);
    }

    @Test
    public void findByComment() {
        // 모든 컬럼 select
        comments.findById(10L);

        System.out.println("======================================");

        // 인터페이스에 정의된 컬럼만 select
        comments.findByComment("comment", CommentSummary.class)
                .ifPresent(c -> System.out.println(c.upAndDown()));
    }
}