package com.example.myazureapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myazureapp.entity.Post;
import java.util.Optional;
import java.util.List;



public interface PostRepository extends MongoRepository<Post, String> {
    Optional<Post> findById(String id);


    List<Post> findByUserId(String userId);

    long countByUserId(String id);
    
}
