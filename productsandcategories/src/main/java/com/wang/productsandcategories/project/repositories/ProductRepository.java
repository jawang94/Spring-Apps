package com.wang.productsandcategories.project.repositories;

import com.wang.productsandcategories.project.models.Category;
import com.wang.productsandcategories.project.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    public List<Product> findAll();
    public List<Product> findAllByCategoriesOrderByCreatedAt(Category category);
}
