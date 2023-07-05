package me.kktrkkt.springdata.jpa_repository.entity_graph;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// 엔티티를 그룹으로 묶는다
@NamedEntityGraph(name = "Comment.post",
        attributeNodes = @NamedAttributeNode("post"))
@Entity
@Getter @Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
