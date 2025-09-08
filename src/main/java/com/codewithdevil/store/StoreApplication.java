package com.codewithdevil.store;

import com.codewithdevil.store.entities.Address;
import com.codewithdevil.store.entities.Profile;
import com.codewithdevil.store.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        var user = User.builder()
                .name("admin")
                .password("admin")
                .email("xyz.com")
                .build();

        var address = Address.builder()
                .street("123 Main St")
                .city("Dublin")
                .state("NY")
                .zipcode("123")
                .build();

        user.addAddress(address);

        user.addTag("tag1");

        var profile = Profile.builder()
                        .bio("admin")
                        .build();

        user.addProfile(profile);

        System.out.println(user);

    }

}
