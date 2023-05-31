package it.altaformazione.foodme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.altaformazione.foodme.models.User;
import it.altaformazione.foodme.models.UserDTO;
import it.altaformazione.foodme.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping(path = "")
    public ResponseEntity<List<User>> list() {

        return new ResponseEntity<List<User>>(this.userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public User user(@PathVariable Long id) {
        return this.userService.getUser(id).orElse(User.builder().build());
    }

    @PostMapping(path = "")
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO) {
        try {
            User user = this.userService.createUser(userDTO);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>("Cammot create user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
