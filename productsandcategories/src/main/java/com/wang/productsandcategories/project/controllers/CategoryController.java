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
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @RequestMapping("/categories/new")
    public String newCategory(Model model, @ModelAttribute("category")Category category) {
        return "/views/newCategory.jsp";
    }

    @RequestMapping(value = "/categories/new", method = RequestMethod.POST)
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/categories/new";
        } else {
            categoryService.createCategory(category);
            return "redirect:/categories/new";
        }
    }

    @RequestMapping(value = "/categories/{id}")
    public String showCategory(Model model, @ModelAttribute("category") Category category, @PathVariable(value="id") Long id) {
        Category c = categoryService.findCategory(id);
        List<Product> thisProducts = productService.findProductByCategory(c);
        List<Product> allProducts = productService.findAll();
        model.addAttribute("c", c);
        model.addAttribute("thisProducts", thisProducts);
        model.addAttribute("allProducts", allProducts);
        return "/views/category.jsp";
    }

    @RequestMapping(value="/categories/{id}/add", method= RequestMethod.POST)
    public String addCategories(@Valid @ModelAttribute("category") Category category, BindingResult result, @PathVariable(value = "id") Long id) {
        if (result.hasErrors()) {
            return "redirect:/categories/" + id;
        } else {
            Category c = categoryService.findCategory(id);
            categoryService.addProducts(category, c);
            return "redirect:/categories/" + id;
        }
    }
}
