package com.codewithdevil.store.repositories;

import com.codewithdevil.store.entities.Category;
import com.codewithdevil.store.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);

    List<Product> findProductsByCategory(Category category);
}
