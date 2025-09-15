package com.codewithdevil.store.services;

import com.codewithdevil.store.entities.Category;
import com.codewithdevil.store.entities.Product;
import com.codewithdevil.store.repositories.CategoryRepository;
import com.codewithdevil.store.repositories.ProductRepository;
import com.codewithdevil.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public void addProduct() {
        var product = Product.builder()
                .name("product1")
                .description("description1")
                .price(BigDecimal.valueOf(200.00))
                .build();

        var category = Category.builder()
                .name("category1")
                .build();

        product.addCategory(category);

        productRepository.save(product);
    }

    @Transactional
    public void anotherProduct() {
        var category = categoryRepository.findById(5L).orElseThrow();

        var product = Product.builder()
                .name("product2")
                .description("description2")
                .price(BigDecimal.valueOf(200.00))
                .build();

        product.addCategory(category);

        productRepository.save(product);
    }

    @Transactional
    public void productsToWishlist() {
        var user = userRepository.findById(11L).orElseThrow();
        productRepository.findAll().forEach(user::addWishlist);
        userRepository.save(user);
    }

    public void deleteProduct() {
        productRepository.deleteById(6L);
    }

    @Transactional
    public void updateProductPrice(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(230.00), (byte) 5);
    }

}
