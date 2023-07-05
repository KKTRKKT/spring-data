package me.kktrkkt.springdata.jpa_repository.entity_graph;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository comments;

    @Test
    void entityGraphTest() {
        // eager 모드로 로드한다
        comments.readById(1L);
        System.out.println("===============================================");
        // lazy 모드로 로드한다
        comments.findById(2L);
    }
}