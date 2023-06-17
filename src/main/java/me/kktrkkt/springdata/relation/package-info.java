package me.kktrkkt.springdata.relation;

/*
테이블간의 관계에는 주종관계가 성립한다. FK키를 가지고 있는 쪽이 주인이고, 영속화도 주인쪽에서 진행

단방향 관계를 정의하려면 @ManyToOne 또는 @OneToMany를 정의하면 된다. 관계를 정의한 쪽이 주인이다
테이블 실제 생성
@ManyToOne, 관계 정의한 쪽에 FK키 생성
@OneToMany, 매핑 테이블을 생성

양방향 관계를 정의하려면 양쪽 테이블에 @ManyToOne, @OneToMany(mappedBy)를 정의한다. @ManyToOne이 FK키를 가지므로 주인이다.
영속화를 시키려면 주인쪽에 종속 관계를 추가하고 진행해야한다.

 */