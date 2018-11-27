package com.wang.productsandcategories.project.services;

import com.wang.productsandcategories.project.models.Category;
import com.wang.productsandcategories.project.models.Product;
import com.wang.productsandcategories.project.repositories.CategoryRepository;
import com.wang.productsandcategories.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryService (CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<Category> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return  categoryList;
    }


    public Category createCategory(Category c) {
        return categoryRepository.save(c);
    }

    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }

    public Category addProducts(Category newCategory, Category oldCategory) {
        Category categoryToUpdate = findCategory(oldCategory.getId());
        List<Product> newList = newCategory.getProducts();
        List<Product> oldList = oldCategory.getProducts();
        oldList.addAll(newList);
        categoryToUpdate .setProducts(oldList);
        return categoryRepository.save(categoryToUpdate);
    }

    public List<Category> findCategoryByProduct(Product product) {
        List<Category> categoryList = categoryRepository.findAllByProductsOrderByCreatedAt(product);
        return categoryList;
    }
}