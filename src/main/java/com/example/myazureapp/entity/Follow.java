package com.example.myazureapp.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Follow {
    @Id
    private String id;

    private String user;

    private String followedByUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    public Follow() {
    }

    public Follow(String user, String followedByUser, Date createTime) {
        this.user = user;
        this.followedByUser = followedByUser;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFollowedByUser() {
        return followedByUser;
    }

    public void setFollowedByUser(String followedByUser) {
        this.followedByUser = followedByUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
}
