package com.codewithdevil.store.repositories;

import com.codewithdevil.store.dtos.UserSummary;
import com.codewithdevil.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile,Long> {

//    @Query("select p.id as id, p.user.email as email from Profile p where p.loyaltyPoints > :loyaltyPoints order by p.user.email")
//    @EntityGraph(attributePaths = "user")
//    List<UserSummary> findWithLoyaltyPoints(@Param("loyaltyPoints") int loyaltyPoints);
}
