package me.kktrkkt.springdata.jpa_repository.auditing;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @CreatedDate
    private Date createdDate;

    @CreatedBy
    @ManyToOne
    private Account createBy;

    @LastModifiedDate
    private Date lastModifiedDate;

    @LastModifiedBy
    @ManyToOne
    private Account lastModifyBy;
}
