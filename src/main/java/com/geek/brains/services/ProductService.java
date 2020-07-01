package com.geek.brains.services;

import com.geek.brains.model.Product;
import com.geek.brains.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepositories productRepositories;

    @Autowired
    public ProductService(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    public List<Product> getAllProducts(){
        return productRepositories.findAll();
    }

    public void addProduct(Product product){
        productRepositories.addProduct(product);
    }

    public Product findById(Long id) {
        return productRepositories.findBuId(id);
    }

    public void editProduct(Product editProduct) {
        productRepositories.editProduct(editProduct);
    }
}
