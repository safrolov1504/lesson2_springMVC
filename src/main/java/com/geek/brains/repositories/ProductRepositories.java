package com.geek.brains.repositories;

import com.geek.brains.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepositories {
    private List<Product> products;
    private Long maxId;

    @PostConstruct
    public void init(){
        this.products = new ArrayList<>();
        this.products.add(new Product(1L,"PS",500));
        this.products.add(new Product(2L,"Phone",300));
        this.products.add(new Product(3L,"Key board",50));
        maxId = 3L;
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

    public void addProduct(Product product){
        maxId++;
        product.setId(maxId);
        this.products.add(product);

    }

    public Product findBuId(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId()  == id){
                return products.get(i);
            }
        }

        throw new RuntimeException("What???");
    }

    public void editProduct(Product editProduct) {
        int i;
        for (i = 0; i < products.size(); i++) {
            if(products.get(i).getId()  == editProduct.getId()){
                break;
            }
        }
        products.get(i).setName(editProduct.getName());
        products.get(i).setCost(editProduct.getCost());
    }
}
