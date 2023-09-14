package com.example.myazureapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.myazureapp.entity.User;
import com.example.myazureapp.repository.UserRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/auth")
public class Mycontroller {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "/index")
    public String getMethodName() {
        User user = userRepository.findByUsername("user").orElseThrow();
        System.out.println(user.toString());
        return user.toString();
    }

}
