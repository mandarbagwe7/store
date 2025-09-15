package com.codewithdevil.store.repositories;

import com.codewithdevil.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile,Long> {
}
