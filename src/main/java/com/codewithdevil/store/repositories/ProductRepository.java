package com.codewithdevil.store.repositories;

import com.codewithdevil.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    //String
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameNotContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);

    //Number
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    //Null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    //Multiple Condition
    List<Product> findByDescriptionNullAndNameNull();

    //Sort (Order By)
    List<Product> findByNameOrderByPrice(String name);

    //Limit (Top/First)
    List<Product> findTop5ByNameOrderByPriceDesc(String name);
    List<Product> findFirst5ByNameOrderByPriceDesc(String name);

    //SQL
    //    @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
    //    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);


    //JPQL
    //    @Query("select p from Product p where p.price between :min and :max order by p.name")
    @Query("select p from Product p join Category c where p.price between :min and :max order by p.name")
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("select count(*) from Product p where p.price between :min and :max order by p.name")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("update Product p set p.price = :price where p.category.id = :categoryId")
    void updatePriceByCategory(@Param("price") BigDecimal price, @Param("categoryId") Byte categoryId);

}
