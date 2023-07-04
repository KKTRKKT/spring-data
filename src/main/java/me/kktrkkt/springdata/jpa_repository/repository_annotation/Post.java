package me.kktrkkt.springdata.jpa_repository.repository_annotation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Post {

    @Id
    private Long id;
}
