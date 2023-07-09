package me.kktrkkt.springdata.jpa_repository.entity_graph;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // FETCH(기본값) : @NamedEntityGraph에 설정한 @NamedAttributeNode들을 EAGER로 로드하고 나머지는 LAZY, 단 연관관계 객체만 해당
    // LOAD : @NamedEntityGraph에 설정한 @NamedAttributeNode들을 EAGER로 로드하고, 나머지는 기본설정
    @EntityGraph(value = "Comment.post", type= EntityGraph.EntityGraphType.FETCH)
    Comment readById(Long id);

    // 그룹 지정이 필요없으면 아래 방식으로 사용한다
//    @EntityGraph(attributePaths = "post", type= EntityGraph.EntityGraphType.FETCH)
//    Comment readById(Long id);
}
