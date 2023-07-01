package me.kktrkkt.springdata.spring_data_common.domain_converter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
