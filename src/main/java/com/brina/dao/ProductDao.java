package com.brina.dao;

import com.brina.model.Product;

public interface ProductDao extends GenericDao<Product>{
   // Product getProductById (Integer id);

    Product getProductByIdWithCategory(Long id);

    //List<Product> getAllProducts();

    //Product addProduct(Product product);
}
