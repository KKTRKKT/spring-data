package me.kktrkkt.springdata.jpa_repository.projection;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 인터페이스 기반 프로젝션 , 추천
//    Optional<CommentSummary> findByComment(String comment);

    // 클래스 기반 프로젝션
//    Optional<CommentList> findByComment(String comment);

    // 메소드명이 같으면 오버라이딩이 되지 않으므로 리턴 클래스 타입을 받아서 리턴
    <T> Optional<T> findByComment(String comment, Class<T> type);
}
