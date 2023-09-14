package com.example.myazureapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myazureapp.entity.User;
import java.util.Optional;



public interface UserRepository extends MongoRepository<User, String> {
   Optional<User> findByUsername(String username);

   Optional<User> findById(String id);

   Boolean existsByUsername(String username);

}
