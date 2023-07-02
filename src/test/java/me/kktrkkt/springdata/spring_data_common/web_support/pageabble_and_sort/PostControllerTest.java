package me.kktrkkt.springdata.spring_data_common.web_support.pageabble_and_sort;

import org.hamcrest.Matcher;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.regex.MatchResult;
import java.util.stream.IntStream;

import static org.hamcrest.core.StringContains.containsStringIgnoringCase;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void posts() throws Exception {
        IntStream.range(0, 30).forEach(x -> persistPost("post"+x));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/posts")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sort", "created,desc")
                        .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsStringIgnoringCase("\"size\":10")));
    }

    private void persistPost(String title) {
        Post post = new Post();
        post.setTitle(title);
        entityManager.persist(post);
    }
}