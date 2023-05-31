package it.altaformazione.foodme.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.altaformazione.foodme.models.User;
import it.altaformazione.foodme.models.UserDTO;
import it.altaformazione.foodme.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    // Dependency Injection della repository User.
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(Long id) throws Exception {
        Optional<User> u = this.userRepository.findById(id);
        if (u.isPresent()) {
            return u.get();
        }
        throw new Exception();
    }

    @Override
    public User getUserByGender(String gender) throws Exception {
        Optional<User> u = this.userRepository.findByGender(gender);
        if (u.isPresent()) // () -> {return x}
            return u.get();
        throw new Exception();
    }

    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        try {
            return this.userRepository.save(
                    User.builder()
                            .name(userDTO.getName())
                            .email(userDTO.getEmail())
                            .mobile(userDTO.getMobile())
                            .gender(userDTO.getGender()).build()

            );
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<User> findPaginatedUser(Pageable pageable) throws Exception {

        return this.userRepository.findAll(pageable);
    }

}
