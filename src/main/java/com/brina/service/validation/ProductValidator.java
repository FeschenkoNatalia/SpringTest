package com.brina.service.validation;

import com.brina.dao.ProductDao;
import com.brina.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductValidator implements Validator<Product> {

    @Autowired
    ProductDao productDao;

    @Override
    public void validate(final Product product) {
        List<Product> productList = productDao.readAll(Product.class);
        String s1 = product.getProductName();
        boolean result = productList.stream().map(Product::getProductName).anyMatch(s -> s.equals(s1));
        if (result) {
            throw new IllegalArgumentException("Product name already exists");
        }
        Long id = product.getId();
        Product product1 = productDao.read(Product.class, id);
        if (product1.getDescription().isEmpty()){
            throw new IllegalArgumentException("Product description is empty");
        }
        if (product1.getPrice().equals(null)){
            throw new IllegalArgumentException("Product price is 0");
        }
    }
}
