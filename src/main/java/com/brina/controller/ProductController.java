package com.brina.controller;

import com.brina.model.Category;
import com.brina.model.Product;
import com.brina.service.CategoryService;
import com.brina.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
    public class ProductController {

    @Autowired
    private final ProductService productService;

    @Autowired
    public ProductController (ProductService productService){
        this.productService = productService;
    }

    @Autowired
    private CategoryService categoryService;


  /*  @RequestMapping("/product")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product";
    }*/

    @RequestMapping("/product")
    public String getProductByIdWithCategory(@RequestParam(value = "id", required = true) Long id, Model model){
        Product product = productService.getProductByIdWithCategory(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/product/add")
    public String addProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "addProduct";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct (@ModelAttribute("newProduct") Product product, Model model){

        Product existingProduct = productService.addProduct(product);
        if (existingProduct!=null) {
            model.addAttribute("productFromDb", existingProduct);
            model.addAttribute("message", "Product is added successfully");
        }
        return "addProduct";
    }
}
