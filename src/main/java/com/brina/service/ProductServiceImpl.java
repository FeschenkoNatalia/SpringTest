package com.brina.service;

import com.brina.dao.ProductDao;
import com.brina.model.Product;
import com.brina.service.validation.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductValidator productValidator;

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Long id) {
        return productDao.read(Product.class, id);
    }

    @Override
    public Product getProductByIdWithCategory(Long id) {
        return productDao.getProductByIdWithCategory(id);
    }

    @Override
    public Product addProduct(Product product) {
        productValidator.validate(product);
        return productDao.create(product);
    }
}
