package me.kktrkkt.springdata.jpa_repository.query_and_sort;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p, p.title AS pTitle FROM #{#entityName} AS p WHERE p.title = :title")
    List<Post> findByTitle(@Param("title") String title, Sort sort);

}