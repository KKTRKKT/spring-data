package me.kktrkkt.springdata.spring_data_common.query;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // 메소드 이름으로 쿼리 생성
    List<Post> findByTitleContains(String title);

    // JPQL 쿼리 생성
    @Query("select p from #{#entityName} as p where p.title like %:title%")
    List<Post> jpqlFindByTitleContains(@Param("title") String title);

    // SQL 쿼리 생성
    @Query(value = "select * from #{#entityName} where title like %:title%", nativeQuery = true)
    List<Post> sqlFindByTitleContains(@Param("title") String title);

    // 리턴 타입 List, Page, Slice, 등등

    // likeCount 수보다 큰 포스트 중 상위 2개만 리스팅
    List<Post> findTop2ByLikesGreaterThanEqual(int likeCount);

}
