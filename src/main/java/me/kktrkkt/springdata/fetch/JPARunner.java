package me.kktrkkt.springdata.fetch;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Order(1)
@Component
public class JPARunner implements ApplicationRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        // @OneToMany 연관관계의 엔티티들을 Lazy 로딩 방식으로 불러옴
        // Lazy 로딩 방식은 해당 엔티티가 호출될 때 불러오는 방식
        // post를 select하고 commentList를 호출할때 한번더 select한다
        // 로딩 방식을 변경하려면 fetch 옵션을 Eager 또는 Lazy로 변경한다
//        final Post post = entityManager.find(Post.class, 1L);

        // @ManyToOne 연관관계의 엔티티들은 Eager 로딩 방식으로 불러옴
        // Eager 로딩 방식은 모든 엔티티들을 미리 불러오는 방식
        // select문을 한번만 실행
        final Comment comment = entityManager.find(Comment.class, 2L);
    }
}
