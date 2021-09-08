package com.minz.web.user.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
@DynamicInsert
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(unique = true)
    private String email;
    private String password;
    private String nickname;

    @Column(columnDefinition = "VARCHAR(45) DEFAULT 'WELCOME'")
    private String grade;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer point;
    private String housingType;
    private String houseSize;
    private String birthDay;

    @Column(columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String gender;
    private String socialLoginType;

    @Column
    private String myURL;
    private String selfIntro;

    public String getMyURL() {
        return myURL;
    }

    public void setMyURL(String myURL) {
        this.myURL = myURL;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }

    @CreatedDate
    private Timestamp createdDate;

    @LastModifiedDate
    private Timestamp updatedDate;

    @Column(columnDefinition = "INT DEFAULT 1")
    private Integer status;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<UserRole> roleSet = new HashSet<>();
    //빌더로 생성.

    public void addUserRole(UserRole userRole) {
        roleSet.add(userRole);
    }


}