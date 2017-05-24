package com.brina.controller;

import com.brina.model.Category;
import com.brina.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController (CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @RequestMapping("/category")
    public String getCategoryByIdWithProducts(@RequestParam(value = "id", required = true) Long id, Model model){
        Category category = categoryService.getCategoryByIdWithProducts(id);
        model.addAttribute("category", category);
        return "category";
    }

    @RequestMapping("/category/add")
    public String addCategory(Model model) {
        model.addAttribute("newCategory", new Category());
        return "addCategory";
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String addCategory (@ModelAttribute("newCategory") Category category, Model model){
        Category existingCategory = categoryService.addCategory(category);
        if (existingCategory!=null){
            model.addAttribute("categoryFromDb", existingCategory);
            model.addAttribute("message", "Category is added successfully");
        }
        return "addCategory";
    }
}
