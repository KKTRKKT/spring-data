package me.kktrkkt.springdata.spring_data_common.query_dsl;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String nickname;
}
