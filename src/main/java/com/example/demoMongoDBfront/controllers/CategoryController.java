package com.example.demoMongoDBfront.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;

import com.example.demoMongoDBfront.model.Category;
import com.example.demoMongoDBfront.services.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    RestClient.Builder restClientBuilder;

    @GetMapping("/allCategories")
    public String allCategories(Model model) {
        List<Category> category = categoryService.getCategories("categories");
        model.addAttribute("categories", category);
        return "categories";
    }

    @GetMapping("/addCategory")
    public String addCategoryForm(Model model) {
        Category newCategory = new Category("");
        model.addAttribute("category", newCategory);
        return "addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/allCategories";
    }

}
