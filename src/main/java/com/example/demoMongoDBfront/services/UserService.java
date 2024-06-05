package com.example.demoMongoDBfront.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demoMongoDBfront.models.User;

@Service
public class UserService {
    
    RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getUsers(String name) {
        User[] usersArray = this.restTemplate.getForObject("http://localhost:8080/{name} ", User[].class, name);
        
        return Arrays.asList(usersArray);
    }
}
