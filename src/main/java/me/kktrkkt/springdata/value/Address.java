package me.kktrkkt.springdata.value;

import lombok.*;

import javax.persistence.Embeddable;

@NoArgsConstructor @AllArgsConstructor
@Embeddable // composite value 타입 선언
@Getter @Setter @Builder
public class Address {
    private String street, city, state, zipCode;
}
