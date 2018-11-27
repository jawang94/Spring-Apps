package com.wang.productsandcategories.project.controllers;

import com.wang.productsandcategories.project.models.Category;
import com.wang.productsandcategories.project.models.Product;
import com.wang.productsandcategories.project.services.CategoryService;
import com.wang.productsandcategories.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/products/new")
    public String newProduct(Model model, @ModelAttribute("product") Product product) {
        return "/views/newProduct.jsp";
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products/new";
        } else {
            productService.createProduct(product);
            return "redirect:/products/new";
        }
    }

    @RequestMapping(value = "/products/{id}")
    public String showProduct(Model model, @ModelAttribute("product") Product product, @PathVariable(value="id") Long id) {
        Product p = productService.findProduct(id);
        List<Category> thisCategories = categoryService.findCategoryByProduct(p);
        List<Category> allCategories = categoryService.findAll();
        model.addAttribute("p", p);
        model.addAttribute("thisCategories", thisCategories);
        model.addAttribute("allCategories", allCategories);
        return "/views/product.jsp";
    }

    @RequestMapping(value="/products/{id}/add", method= RequestMethod.POST)
    public String addCategories(@Valid @ModelAttribute("product") Product product, BindingResult result, @PathVariable(value = "id") Long id) {
        if (result.hasErrors()) {
            return "redirect:/products/" + id;
        } else {
            Product p = productService.findProduct(id);
            productService.addCategories(product, p);
            return "redirect:/products/" + id;
        }
    }
}
