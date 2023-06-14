package me.kktrkkt.springdata;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Study {
    @Id @GeneratedValue
    private Long id;

    private String name;

//    @ManyToOne // 다(study) 대 일(account) 관계
//    private Account owner; // 변수명_id로 생성되고, 외래키로 묶인다
}
