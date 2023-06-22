package me.kktrkkt.springdata.spring_data_common.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // 메소드 이름으로 쿼리 생성
    List<Post> findByTitleContains(String title);

    // JPQL 쿼리 생성
    @Query("select p from Post as p where p.title like %:title%")
    List<Post> jpqlFindByTitleContains(@Param("title") String title);

    // SQL 쿼리 생성
    @Query(value = "select * from post where title like %:title%", nativeQuery = true)
    List<Post> sqlFindByTitleContains(@Param("title") String title);
}
