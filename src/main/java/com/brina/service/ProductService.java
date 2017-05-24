package com.brina.service;

import com.brina.model.Product;


public interface ProductService {

        Product getProductById (Long id);

        Product getProductByIdWithCategory(Long id);

        Product addProduct (Product product);

        //List<Product> getAllProducts ();
    }
