package me.kktrkkt.springdata.spring_data_common.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByCommentContainsIgnoreCase(String comment);

    List<Comment>  findByOrderByLikeCountDesc();

    Page<Comment> findByCommentContainsIgnoreCase(String comment, Pageable pageable);
}
