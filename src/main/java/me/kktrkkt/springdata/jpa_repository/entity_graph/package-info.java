package me.kktrkkt.springdata.jpa_repository.entity_graph;

/*
EntityGraph는 쿼리또는 메소드마다 연관관계 fetch 전략을 설정할 수 있는 기능이다.

EntityGraph 전략
- FETCH(기본값) : @NamedEntityGraph에 설정한 @NamedAttributeNode들을 EAGER로 로드하고 나머지는 LAZY, 단 연관관계 객체만 해당
- LOAD : @NamedEntityGraph에 설정한 @NamedAttributeNode들을 EAGER로 로드하고, 나머지는 기본설정
 */