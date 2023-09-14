package com.example.myazureapp.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Document("user")
public class User {

    private String id;
    private String username;

    
    private String password;

    private String phoneNumber;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    //头像图片地址
    private String avatarUrl;
    //性别
    private String gender;
    //地址
    private String address;
    //一句话介绍
    private String briefIntro;
    //个人简介
    private String personalIntro;
    //职业
    private String profession;
    //职业经历
    private String career;
    //教育经历
    private String educationExp;
    //谁关注了我，粉丝
    private List<User> whoFollowsMe;
    //我关注了谁，关注
    private List<User> whoIFollow;

    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String id, String username, String password, String phoneNumber, String email, Date createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> role) {
        this.roles = role;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBriefIntro() {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro) {
        this.briefIntro = briefIntro;
    }

    public String getPersonalIntro() {
        return personalIntro;
    }

    public void setPersonalIntro(String personalIntro) {
        this.personalIntro = personalIntro;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getEducationExp() {
        return educationExp;
    }

    public void setEducationExp(String educationExp) {
        this.educationExp = educationExp;
    }

    public List<User> getWhoFollowsMe() {
        return whoFollowsMe;
    }

    public void setWhoFollowsMe(List<User> whoFollowsMe) {
        this.whoFollowsMe = whoFollowsMe;
    }

    public List<User> getWhoIFollow() {
        return whoIFollow;
    }

    public void setWhoIFollow(List<User> whoIFollow) {
        this.whoIFollow = whoIFollow;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", phoneNumber=" + phoneNumber
                + ", email=" + email + ", role=" + roles.toString() + "]";
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
