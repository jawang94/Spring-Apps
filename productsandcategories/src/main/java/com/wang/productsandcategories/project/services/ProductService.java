package com.wang.productsandcategories.project.services;

import com.wang.productsandcategories.project.models.Category;
import com.wang.productsandcategories.project.models.Product;
import com.wang.productsandcategories.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();
        return  productList;
    }

    public Product createProduct(Product p) {
        return productRepository.save(p);
    }

    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }

    public Product addCategories(Product newProduct, Product oldProduct) {
        Product productToUpdate = findProduct(oldProduct.getId());
        List<Category> newList = newProduct.getCategories();
        List<Category> oldList = oldProduct.getCategories();
        oldList.addAll(newList);
        productToUpdate .setCategories(oldList);
        return productRepository.save(productToUpdate);
    }

    public List<Product> findProductByCategory(Category category) {
        List<Product> productList = productRepository.findAllByCategoriesOrderByCreatedAt(category);
        return productList;
    }
}
