package it.altaformazione.foodme.services;

import org.springframework.stereotype.Service;

import it.altaformazione.foodme.models.User;
import it.altaformazione.foodme.models.UserDTO;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    
    List<User> getUsers();

    Optional<User> getUser(Long id);

    User getUserByGender(String gender) throws Exception;

    User createUser(UserDTO userDTO) throws Exception;

}
