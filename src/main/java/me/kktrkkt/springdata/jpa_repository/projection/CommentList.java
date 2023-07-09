package me.kktrkkt.springdata.jpa_repository.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 모든 변수의 생성자 필수
@AllArgsConstructor
@Getter
public class CommentList {

    private String comment;

    private int up;

    private int down;

    public String upAndDown() {
        return "UP: " + getUp() + ' ' + "DOWN: " + getDown();
    }

}
