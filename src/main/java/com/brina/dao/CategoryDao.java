package com.brina.dao;

import com.brina.model.Category;

public interface CategoryDao extends GenericDao<Category>{

    Category getCategoryByIdWithProducts(Long id);

}
