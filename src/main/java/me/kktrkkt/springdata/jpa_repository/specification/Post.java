package me.kktrkkt.springdata.jpa_repository.specification;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private int viewCount;

    private boolean isPrivate = false;
}
