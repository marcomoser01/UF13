package it.altaformazione.foodme.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.altaformazione.foodme.models.User;
import it.altaformazione.foodme.models.UserDTO;

public interface UserService {

    List<User> getUsers();

    User getUser(Long id) throws Exception;

    User getUserByGender(String gender) throws Exception;

    User createUser(UserDTO userDTO) throws Exception;

    Page<User> findPaginatedUser(Pageable pageable) throws Exception;
}
