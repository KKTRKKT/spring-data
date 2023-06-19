package me.kktrkkt.springdata.fetch;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.EAGER) // 기본값
    private Post post;
}
