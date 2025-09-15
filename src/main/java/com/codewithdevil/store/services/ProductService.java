package com.codewithdevil.store.services;

import com.codewithdevil.store.entities.Category;
import com.codewithdevil.store.entities.Product;
import com.codewithdevil.store.repositories.CategoryRepository;
import com.codewithdevil.store.repositories.ProductRepository;
import com.codewithdevil.store.repositories.UserRepository;
import com.codewithdevil.store.repositories.specifications.ProductSpec;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
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

    public void getProductByCategory(){
        var products = productRepository.findByCategory(new Category((byte)5));
        System.out.println(products);
    }

    @Transactional
    public void getProductsByProcedure(){
        var products = productRepository.findProductsProc(BigDecimal.valueOf(20), BigDecimal.valueOf(500));
        System.out.println(products);
    }

    public void fetchProducts(){
        var product = new Product();
        product.setName("product");
        var matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withIgnorePaths("id", "description")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        var example = Example.of(product, matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    public void fetchProductByCriteria(){
        var products = productRepository.findProductsByCriteria("prod", BigDecimal.valueOf(1), BigDecimal.valueOf(1000));
        products.forEach(System.out::println);
    }

    public void fetchProductsBySpecification(String name, BigDecimal minPrice, BigDecimal maxPrice){
        Specification<Product> spec = Specification.where(null);

        if (name != null) {
            spec = spec.and(ProductSpec.hasName(name));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpec.hasPriceLessThanOrEqualTo(maxPrice));
        }

        productRepository.findAll(spec).forEach(System.out::println);
    }

    public void fetchSortedProducts(){
        var sort = Sort.by("name")
                .and(Sort.by("price").descending());
        productRepository.findAll(sort).forEach(System.out::println);
    }

    public void fetchPaginatedProducts(int pageNumber, int pageSize){
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Product> page = productRepository.findAll(pageRequest);

        var products = page.getContent();
        products.forEach(System.out::println);

        var totalPages = page.getTotalPages();
        var totalProducts = page.getTotalElements();
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Total Products: " + totalProducts);
    }

    public void fetchProductsByCategoryCriteria(){
        var products = productRepository.findProductsByCategory(new Category((byte)1));
        products.forEach(System.out::println);
    }

    public void fetchProductsByCategorySpecification(Category category){
        Specification<Product> spec = Specification.where(null);

        if (category != null) {
            spec = spec.and(ProductSpec.hasCategory(category));
        }

        productRepository.findAll(spec).forEach(System.out::println);
    }

}
