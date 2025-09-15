package com.codewithdevil.store.repositories;

import com.codewithdevil.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
