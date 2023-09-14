package com.example.myazureapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myazureapp.entity.Follow;
import java.util.List;
import java.util.Optional;


public interface FollowRepository extends MongoRepository<Follow, String> {
    
    List<Follow> findByUser(String user);
    long countByUser(String followedByUser);
    long countByFollowedByUser(String followedByUser);
    List<Follow> findByFollowedByUser(String followedByUser);
    Optional<Follow> findByUserAndFollowedByUser(String user, String user1);
}
