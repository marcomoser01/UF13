package it.altaformazione.foodme.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.altaformazione.foodme.models.User;
import it.altaformazione.foodme.models.UserDTO;
import it.altaformazione.foodme.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User getUserByGender(String gender) throws Exception {
        Optional<User> u = this.userRepository.findByGender(gender);
        if (u.isPresent()) {
            return u.get();
        }
        throw new Exception();
    }

    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        User us = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getMobile(), userDTO.getGender(), null);
        try {
            return this.userRepository.save(us);
        } catch (Exception e) {
            throw new Exception();
        }

    }

}