package it.altaformazione.foodme.repositories;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import it.altaformazione.foodme.models.User;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> { // CrudRepository, Repository
    Optional<User> findByGender(String gender);

    // @Query("select u from User u where u.id = ?")
    // Optional<User> customFindUserById(@Param("id") Long id);
}
