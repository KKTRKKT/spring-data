package me.kktrkkt.springdata.spring_data_common.custom_repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;
}
