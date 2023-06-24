package me.kktrkkt.springdata.spring_data_common.query;

/*
스프링 데이터 JPA의 쿼리 생성 전략은 3가지가 존재한다.

- CREATE : 메소드 이름을 분석해 쿼리 생성
- USE_DECLARED_QUERY : 미리 정의해둔 쿼리를 찾아 생성
- CREATE_IF_NOT_FOUND: 기본 전략으로, 미리 정의해둔 쿼리를 찾고 정의해둔 쿼리가 없으면 메소드 이름을 분석해 쿼리를 생성하는 방법

생성 전략은 @EnableJpaRepositories의 queryLookupStrategy 옵션에서 설정할 수 있다

 */