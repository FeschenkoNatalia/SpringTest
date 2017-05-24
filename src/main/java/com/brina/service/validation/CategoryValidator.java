package com.brina.service.validation;

import com.brina.dao.CategoryDao;
import com.brina.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryValidator implements Validator<Category> {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public void validate(final Category category) {
        List<Category> categoryList = categoryDao.readAll(Category.class);
        String s1 = category.getCategoryName();
        boolean result = categoryList.stream().map(Category::getCategoryName).anyMatch(s -> s.equals(s1));
        if (result) {
            throw new IllegalArgumentException("Category name already exists");
        }
        Long id = category.getId();
        Category category1 = categoryDao.read(Category.class,id);
        if (category1.getDescription().isEmpty()){
            throw new IllegalArgumentException("Category description is empty");
        }
    }
}