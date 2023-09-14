package com.example.myazureapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myazureapp.entity.Comment;

import java.util.List;


public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByPostId(String postId);
    long countByPostId(String postId);
}
