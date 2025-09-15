package com.codewithdevil.store.repositories;

import com.codewithdevil.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
