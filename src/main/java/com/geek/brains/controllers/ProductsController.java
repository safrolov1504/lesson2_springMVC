package com.geek.brains.controllers;

import com.geek.brains.model.Product;
import com.geek.brains.services.ProductService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showAllProducts(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        return "add_product_form";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product newProduct){
        productService.addProduct(newProduct);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id,Model model){
        model.addAttribute("products",productService.findById(id));
        return "edit_product_form";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product editProduct, Model model){
        productService.editProduct(editProduct);
        return "redirect:/products/";
    }

}
