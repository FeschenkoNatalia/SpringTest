package com.brina.service;

import com.brina.dao.CategoryDao;
import com.brina.model.Category;
import com.brina.service.validation.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryValidator categoryValidator;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.readAll(Category.class);
    }

    @Override
    public Category getCategoryById(Long id){
        return categoryDao.read(Category.class,id);
    }

    @Override
    public Category getCategoryByIdWithProducts(Long id) {
        return categoryDao.getCategoryByIdWithProducts(id);
    }


    @Override
    public Category addCategory(Category category) {
        categoryValidator.validate(category);
     //   categoryValidator.validate1(category);
        return categoryDao.create(category);
    }
}
