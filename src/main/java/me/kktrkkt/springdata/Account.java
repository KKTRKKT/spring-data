package me.kktrkkt.springdata;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity // 해당 객체를 테이블에 매핑하는 애노테이션
@Data
public class Account {

    @Id // 식별자 애노테이션
    @GeneratedValue // 값 자동 생성, DB에 따라
    private Long id;

    // @Column (생략) //변수명-컬럼명으로 자동 매핑됨
    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP) // 날짜 컬럼을 매핑해준다
    private Date created = new Date();

    @Transient // 컬럼 매핑 대상에서 제외시킨다
    private Boolean no;

    @Embedded // composite value 사용을 위한 애노테이션
    @AttributeOverrides ( // 다중 @AttributeOverride 선언
            @AttributeOverride(name = "street", column = @Column(name = "home_street") ) // 컬럼을 재작성한다
    )
    private Address address;

    @OneToMany // 일(account) 대 대(study) 관계
    private Set<Study> studies = new HashSet<>();
}


