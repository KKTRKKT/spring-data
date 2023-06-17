package me.kktrkkt.springdata.state;

/*
JPA의 엔티티의 상태에는 총 4가지가 있다

transient: JPA가 모르는 상태
persistent: JPA가 관리하는 상태(성능을 향상 시켜주는 기능 지원, e.g: 1차 캐싱, dirty checing..)
detached: JPA가 더 이상 관리하지 않는 상태
removed: JPA에서 관리하지만 삭제하기로 한 상태

 */