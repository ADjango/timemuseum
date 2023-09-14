package com.example.myazureapp.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document("post")
public class Post {
    
    @Id
    public String id;

    public String title;
    public String content;

    public String userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date createDateTime;

    private List<Tag> tags;

    private List<User> agreedBy;
    private List<User> disagreedBy;
    private List<User> likedBy;
    private List<User> collectedBy;

    public Post(){};

    public Post(String title, String content, String userId, Date date){
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createDateTime = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<User> getAgreedBy() {
        return agreedBy;
    }

    public void setAgreedBy(List<User> agreedBy) {
        this.agreedBy = agreedBy;
    }

    public List<User> getDisagreedBy() {
        return disagreedBy;
    }

    public void setDisagreedBy(List<User> disagreedBy) {
        this.disagreedBy = disagreedBy;
    }

    public List<User> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<User> likedBy) {
        this.likedBy = likedBy;
    }

    public List<User> getCollectedBy() {
        return collectedBy;
    }

    public void setCollectedBy(List<User> collectedBy) {
        this.collectedBy = collectedBy;
    };

    
}
