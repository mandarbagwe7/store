package com.codewithdevil.store.repositories.specifications;

import com.codewithdevil.store.entities.Category;
import com.codewithdevil.store.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpec {
    public static Specification<Product> hasName(String name) {
        return ((root, query, criteriaBuilder) ->  criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%"));
    }

    public static Specification<Product> hasPriceLessThanOrEqualTo(BigDecimal price) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price").as(BigDecimal.class), price));
    }

    public static Specification<Product> hasPriceGreaterThanOrEqualTo(BigDecimal price) {
        return ((root, query, criteriaBuilder) ->  criteriaBuilder.greaterThanOrEqualTo(root.get("price").as(BigDecimal.class), price));
    }

    public static Specification<Product> hasCategory(Category category) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), category));
    }
}
