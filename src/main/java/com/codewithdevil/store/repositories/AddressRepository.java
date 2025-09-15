package com.codewithdevil.store.repositories;

import com.codewithdevil.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
