package me.kktrkkt.springdata.spring_data_common.domain_event;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class PostConfig {

    @EventListener
    public void PostPublishHandler(Post post) {
        System.out.println("-------------------------------");
        System.out.println("post title : " + post.getTitle());
        System.out.println("-------------------------------");
    }
}
