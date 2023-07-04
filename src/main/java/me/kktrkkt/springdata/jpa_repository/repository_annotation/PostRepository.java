package me.kktrkkt.springdata.jpa_repository.repository_annotation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
