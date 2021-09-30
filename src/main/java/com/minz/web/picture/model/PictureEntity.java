package com.minz.web.picture.model;

import com.minz.web.user.model.UserEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "picture")
@DynamicInsert
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class PictureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userIdx", insertable= false, updatable = false)

    private UserEntity userIdx;
    private String housingType;
    private String houseSize;
    private String style;
    private String place;
    @CreatedDate
    private Timestamp createdDate;
    @LastModifiedDate
    private Timestamp updatedDate;
    @Column(columnDefinition = "INT DEFAULT 1")
    private Integer status;

}