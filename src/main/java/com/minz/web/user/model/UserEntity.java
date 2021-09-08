package com.minz.web.user.model;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="user")
@DynamicInsert
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
    Set<UserRole> roleSet;

    public UserEntity() {
    }

    public UserEntity(Set<UserRole> roleSet) {
        this.roleSet = roleSet;
    }

    public void addUserRole(UserRole userRole) {
        roleSet.add(userRole);
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "idx=" + idx +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", grade='" + grade + '\'' +
                ", point=" + point +
                ", housingType='" + housingType + '\'' +
                ", houseSize='" + houseSize + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender='" + gender + '\'' +
                ", socialLoginType='" + socialLoginType + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", status=" + status +
                ", roleSet=" + roleSet +
                '}';
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getHousingType() {
        return housingType;
    }

    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    public String getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(String houseSize) {
        this.houseSize = houseSize;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSocialLoginType() {
        return socialLoginType;
    }

    public void setSocialLoginType(String socialLoginType) {
        this.socialLoginType = socialLoginType;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdAt) {
        this.createdDate = createdAt;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedAt) {
        this.updatedDate = updatedAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<UserRole> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<UserRole> roleSet) {
        this.roleSet = roleSet;
    }
}