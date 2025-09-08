package com.codewithdevil.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);

//        var resource = context.getBean(HeavyResource.class);

//        var orderService = context.getBean(OrderService.class);
//        var orderService2 = context.getBean(OrderService.class);
//        orderService.placeOrder();
//        context.close();

//        var notificationManager = context.getBean(NotificationManager.class);
//        notificationManager.sendNotification("Hello World");

//        var userService = context.getBean(UserService.class);
//        userService.registerUser(new User(1, "Mandar", "mandar@xyz.com", "1234"));
//        userService.registerUser(new User(2, "Mandar B", "mandar@xyz.com", "1234"));


    }

}
