package com.example.myazureapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myazureapp.entity.Role;
import com.example.myazureapp.entity.UserRole;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(UserRole roleName);
}
