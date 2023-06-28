package me.kktrkkt.springdata.spring_data_common.custom_repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter @Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    @OneToMany(mappedBy = "account")
    private List<Post> posts;
}
