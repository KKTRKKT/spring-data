package me.kktrkkt.springdata.spring_data_common.domain_converter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/post/{id}")
    public Post getAPost(@PathVariable("id") Post post){
        return post;
    }
}
