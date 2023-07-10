package me.kktrkkt.springdata.life_cycle;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    // entityManager 영속화 작업 전
    @PrePersist
    public void prePersist() {
        System.out.println("prePersist");
    }

    // entityManager 영속화 작업 후
    @PostPersist
    public void postPersist() {
        System.out.println("postPersist");
    }

    // 데이터베이스 update 작업 전
    @PreUpdate
    public void preUpdate() {
        System.out.println("preUpdate");
    }

    // 데이터베이스 update 작업 후
    @PostUpdate
    public void postUpdate() {
        System.out.println("postUpdate");
    }

    // entityManager 제거 작업 전
    @PreRemove
    public void preRemove() {
        System.out.println("preRemove");
    }

    // entityManager 제거 작업 후
    @PostRemove
    public void postRemove() {
        System.out.println("postRemove");
    }

    // 엔티티가 persist 상태가 된 후
    @PostLoad
    public void postLoad() {
        System.out.println("postLoad");
    }
}
