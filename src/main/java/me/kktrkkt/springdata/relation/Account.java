package me.kktrkkt.springdata.relation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter @Setter
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true) // 프로퍼티로 제약을 설정할 수 있다
    private String username;

    private String password;

//    @OneToMany // 일(account) 대 대(study) 관계
    @OneToMany(mappedBy = "owner") // 양방향 관계 주(account) 종(study)관계,
    // FK 값을 가지고 있는 @ManyToOne이 주인이다.
    // mappedBy는 종속관계에 작성한다
    private Set<Study> studies = new HashSet<>();

    // convenient method
    public void addStudy(Study study) {
        this.studies.add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.studies.remove(study);
        study.setOwner(null);
    }
}


