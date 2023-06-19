package me.kktrkkt.springdata.fetch;

/*
이 패키지에서는 fetch에 대해서 알아본다

fetch는 연관 관계의 엔티티들을 로딩하는 방법이다. select+1 등의 성능문제와 관련있다

@OneToMany는 기본적으로 Lazy 로딩 방식을 사용
@ManyToOne은 기본적으로 Eager 로딩 방식을 사용

 */