package me.kktrkkt.springdata.spring_data_common.web_support.hateoas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
