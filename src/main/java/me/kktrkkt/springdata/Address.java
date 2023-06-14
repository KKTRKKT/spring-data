package me.kktrkkt.springdata;

import javax.persistence.Embeddable;

@Embeddable // composite value 타입 선언
public class Address {
    private String street, city, state, zipCode;
}
