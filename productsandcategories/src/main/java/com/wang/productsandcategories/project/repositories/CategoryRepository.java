package com.wang.productsandcategories.project.repositories;

import com.wang.productsandcategories.project.models.Category;
import com.wang.productsandcategories.project.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    public List<Category> findAll();
    public List<Category> findAllByProductsOrderByCreatedAt(Product product);
}
