package me.kktrkkt.springdata.spring_data_common.query;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    private Integer likeCount = 0;
}
