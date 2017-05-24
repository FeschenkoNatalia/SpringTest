package com.brina.service;

import com.brina.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById (Long id);

    Category getCategoryByIdWithProducts (Long id);

    Category addCategory(Category category);
}
