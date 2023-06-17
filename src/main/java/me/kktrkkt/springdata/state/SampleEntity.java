package me.kktrkkt.springdata.state;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class SampleEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(name="sample_column")
    private String column;
}
