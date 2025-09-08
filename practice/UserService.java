package com.codewithdevil.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        userRepository.save(user);
        notificationService.send("User Registered Successfully", user.getEmail());
    }

}
