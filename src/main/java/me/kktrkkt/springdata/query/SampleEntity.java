package me.kktrkkt.springdata.query;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class SampleEntity {

    @Id @GeneratedValue
    private Long id;

    @Override
    public String toString() {
        return "SampleEntity{" +
                "id=" + id +
                '}';
    }
}
