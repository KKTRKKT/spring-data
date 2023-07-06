package me.kktrkkt.springdata.jpa_repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CommentSummary {

    String getComment();

    int getUp();

    int getDown();

    // default를 이용한 Closed Projection, 쿼리 최적화와 컬럼조합을 같이 사용가능
    default String upAndDown() {
        return "UP: " + getUp() + ' ' + "DOWN: " + getDown();
    }

    // Open Projection 컬럼을 조합해 새로운 컬럼처럼 쓸 수 있다.
    // 스프링 빈 메소드 호출 가능, 단 entity를 가져오므로 쿼리 최적화 불가능
//    @Value("#{'UP: ' + target.up + ' ' + 'DOWN: ' + target.down }")
//    String upAndDown();
}
