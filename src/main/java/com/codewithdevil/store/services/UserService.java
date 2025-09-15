package com.codewithdevil.store.services;

import com.codewithdevil.store.entities.Address;
import com.codewithdevil.store.entities.Profile;
import com.codewithdevil.store.entities.User;
import com.codewithdevil.store.repositories.AddressRepository;
import com.codewithdevil.store.repositories.ProfileRepository;
import com.codewithdevil.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private AddressRepository addressRepository;

    @Transactional
    public void showEntityStates(){
        var user = User.builder()
                .name("John")
                .password("1234")
                .email("john@email.com")
                .build();

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

    }

    @Transactional
    public void showRelatedEntities(){
        var profile = profileRepository.findById(2L).orElseThrow();
//        System.out.println(profile.getBio());
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        Address address = addressRepository.findById(2L).orElse(null);
        System.out.println(address);
    }

    public void persistRelated(){
        var user = User.builder()
                .name("John")
                .password("1234")
                .email("abc@xyz.com")
                .build();

        var address = Address.builder()
                .city("city")
                .street("street")
                .state("state")
                .zipcode("zipcode")
                .build();

        user.addAddress(address);

        userRepository.save(user);

    }

    @Transactional
    public void removeRelated(){
        userRepository.deleteById(2L);

//        var user = userRepository.findById(2L).orElseThrow();
//        var address = user.getAddresses().stream().findFirst().orElseThrow();
//        user.removeAddress(address);
//        userRepository.save(user);
    }

    @Transactional
    public void fetchUser(){
        var user = userRepository.findByEmail("johndoe@email.com").orElseThrow();
        System.out.println(user);
    }

    @Transactional
    public void fetchUsers(){
        var users = userRepository.findAllWithAddresses();
        users.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }

    @Transactional
    public void addUserAndProfile(){
        var user = User.builder()
                .name("John3")
                .password("1234")
                .email("john3@gmail.com")
                .build();

        var profile = Profile.builder()
                .bio("Hello3")
                .build();

        user.addProfile(profile);
        userRepository.save(user);
    }

    @Transactional
    public void findProfiles(){
//        var profiles = profileRepository.findWithLoyaltyPoints(2);
//        profiles.forEach(profile -> {
//            System.out.println(profile.getId());
//            System.out.println(profile.getUser().getEmail());
//        });
//
//        var profiles = profileRepository.findWithLoyaltyPoints(2);
//        profiles.forEach(profile -> {
//            System.out.println(profile.getId());
//            System.out.println(profile.getEmail());
//        });
        var users = userRepository.findLoyalUsers(2);
        users.forEach(u -> {
            System.out.println(u.getId());
            System.out.println(u.getEmail());
        });
    }

}
