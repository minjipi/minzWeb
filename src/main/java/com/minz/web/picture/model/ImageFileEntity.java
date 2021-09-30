package com.minz.web.picture.model;


import lombok.*;

import javax.persistence.*;

@Table(name = "imagefile")
@Entity
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "pictureIdx") //연관 관계시 항상 주의
public class ImageFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String uuid;

    private String imgName;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY) //무조건 lazy로
    private PictureEntity pictureIdx;


}