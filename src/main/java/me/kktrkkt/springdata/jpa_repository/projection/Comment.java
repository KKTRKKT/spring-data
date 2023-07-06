package me.kktrkkt.springdata.jpa_repository.projection;

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

    private int up;

    private int down;

    private Boolean best;
}
