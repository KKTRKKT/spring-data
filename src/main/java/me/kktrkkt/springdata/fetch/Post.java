package me.kktrkkt.springdata.fetch;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY) // 기본값
    private List<Comment> commentList = new ArrayList<>();
}
