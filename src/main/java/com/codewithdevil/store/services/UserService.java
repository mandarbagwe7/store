package com.codewithdevil.store.services;

import com.codewithdevil.store.entities.Address;
import com.codewithdevil.store.entities.User;
import com.codewithdevil.store.repositories.AddressRepository;
import com.codewithdevil.store.repositories.ProfileRepository;
import com.codewithdevil.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
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
}
