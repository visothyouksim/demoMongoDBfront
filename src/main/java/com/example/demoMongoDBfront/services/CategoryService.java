package com.example.demoMongoDBfront.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demoMongoDBfront.model.Category;

@Service
public class CategoryService {

    RestTemplate restTemplate;

    public CategoryService(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    public List<Category> getCategories(String name) {
        Category[] categoriesArray = this.restTemplate.getForObject("http://localhost:8080/{name}", Category[].class, name);

        return Arrays.asList(categoriesArray);
    }

    public void addCategory(Category category) {
        try {
            this.restTemplate.postForObject("http://localhost:8080/addCategory", category, Category.class);
        } catch (Exception e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }

}
