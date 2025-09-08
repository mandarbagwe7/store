package com.codewithdevil.store;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InMemoryUserRepository implements UserRepository{

    private Map<String, User> users = new HashMap<String, User>();

    @Override
    public void save(User user) {
        if(!users.containsKey(user.getEmail())) {
            users.put(user.getEmail(), user);
            System.out.println(users);
        }
        else
            System.out.println(user.getEmail() + " already exists");
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
