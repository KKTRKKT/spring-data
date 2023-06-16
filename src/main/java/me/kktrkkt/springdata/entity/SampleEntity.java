package me.kktrkkt.springdata.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.Date;


@Entity // 해당 객체를 테이블에 매핑하는 애노테이션
@Getter @Setter
public class SampleEntity {

    @Id // 식별자 애노테이션
    @GeneratedValue // 값 자동 생성, DB에 따라
    private Long id;

    // @Column (생략) //변수명-컬럼명으로 자동 매핑됨
    private String column;

    @Temporal(TemporalType.TIMESTAMP) // 날짜 컬럼을 매핑해준다
    private Date created = new Date();

    @Transient // 컬럼 매핑 대상에서 제외시킨다
    private Boolean no;
}

