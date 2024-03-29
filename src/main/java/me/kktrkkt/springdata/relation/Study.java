package me.kktrkkt.springdata.relation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter @Setter
public class Study {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne // 다(study) 대 일(account) 관계
    private Account owner; // 변수명_id로 생성되고, 외래키로 묶인다
}
