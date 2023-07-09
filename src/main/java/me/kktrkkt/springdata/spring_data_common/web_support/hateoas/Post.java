package me.kktrkkt.springdata.spring_data_common.web_support.hateoas;

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
}
