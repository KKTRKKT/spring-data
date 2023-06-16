package me.kktrkkt.springdata.value;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter @Setter
public class SampleEntity {

    @Id
    private Long id;

    @Embedded // composite value 사용을 위한 애노테이션
    @AttributeOverrides ( // 다중 @AttributeOverride 선언
            @AttributeOverride(name = "street", column = @Column(name = "home_street") ) // 컬럼을 재작성한다
    )
    private Address address;
}


