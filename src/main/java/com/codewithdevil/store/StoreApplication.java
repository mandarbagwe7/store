package com.codewithdevil.store;

import com.codewithdevil.store.entities.Category;
import com.codewithdevil.store.services.ProductService;
import com.codewithdevil.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var service = context.getBean(ProductService.class);
        service.fetchProductsByCategorySpecification(new Category((byte)1));
//        service.fetchProductsByCategoryCriteria();
//        service.fetchPaginatedProducts(0, 10);
//        service.fetchSortedProducts();
//        service.fetchProductsBySpecification("prod", null, null);
//        service.fetchProductByCriteria();
//        service.fetchProducts();
//        service.getProductsByProcedure();
//        service.getProductByCategory();
//        service.updateProductPrice();
//        service.deleteProduct();
//        service.addProduct();
//        service.anotherProduct();
//        service.productsToWishlist();

//        var service = context.getBean(UserService.class);
//        service.findProfiles();
//        service.findProfiles();
//        service.addUserAndProfile();
//        service.fetchUsers();
//        service.fetchUser();
//        service.removeRelated();
//        service.persistRelated();
//        service.showRelatedEntities();
//        service.fetchAddress();

//        var repository = context.getBean(UserRepository.class);

//        var user = User.builder()
//                .name("admin")
//                .password("admin")
//                .email("xyz@abc.com")
//                .build();

//        repository.save(user);

//        var user = repository.findById(1L).orElseThrow();
//        System.out.println(user.getEmail());

//        repository.findAll().forEach(x -> System.out.println(x.getEmail()));

//        repository.deleteById(1L);



//        var user = User.builder()
//                .name("admin")
//                .password("admin")
//                .email("xyz.com")
//                .build();
//
//        var address = Address.builder()
//                .street("123 Main St")
//                .city("Dublin")
//                .state("NY")
//                .zipcode("123")
//                .build();
//
//        user.addAddress(address);
//
//        user.addTag("tag1");
//
//        var profile = Profile.builder()
//                        .bio("admin")
//                        .build();
//
//        user.addProfile(profile);
//
//        System.out.println(user);

    }

}
