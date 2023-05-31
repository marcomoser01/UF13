package it.altaformazione.foodme.repositories;

import java.util.Optional;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.altaformazione.foodme.models.User;

public interface UserRepository extends JpaRepository<User, Long>  { //CrudRepository, Repository
    Optional<User> findByGender(String gender);


    // @Query("Select u from user u where u.id = :id")
    // Optional<User> customFindUserByID(@Param("id") Long id);
}
