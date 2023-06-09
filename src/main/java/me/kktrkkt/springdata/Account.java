package me.kktrkkt.springdata;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity // 해당 객체를 테이블에 매핑하는 애노테이션
@Data
public class Account {

    @Id // 식별자 애노테이션
    @GeneratedValue // 값 자동 생성
    private Long id;

    // @Column (생략) //변수명-컬럼명으로 자동 매핑됨
    private String username;

    private String password;
}


