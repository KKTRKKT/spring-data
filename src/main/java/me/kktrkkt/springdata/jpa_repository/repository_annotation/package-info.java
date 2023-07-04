package me.kktrkkt.springdata.jpa_repository.repository_annotation;

/*
JPARepository의 구현체인 SimpleJpaRepository에서 @Repository와 @Transactional(readonly=true)로 설정되어 있다.

@Repository가 있으면 SQLException이나 JPA 관련 예외를 DataAccessException으로 감싸준다.

 */