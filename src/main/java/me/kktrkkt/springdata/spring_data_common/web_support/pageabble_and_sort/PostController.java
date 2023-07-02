package me.kktrkkt.springdata.spring_data_common.web_support.pageabble_and_sort;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository posts;

    @GetMapping("/posts")
    public Page<Post> posts(Pageable pageable) {
        return posts.findAll(pageable);
    }
}
