package it.altaformazione.foodme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping("")
    public ResponseEntity<List<User>> list() {
        return new ResponseEntity<List<User>>(this.userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<?> listPage(Pageable pageable) {

        try {
            return new ResponseEntity<Page<User>>(
                    this.userService.findPaginatedUser(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> user(@PathVariable Long id) {
        try {
            return new ResponseEntity<User>(this.userService.getUser(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<?> user(@PathVariable String gender) {
        try {
            return new ResponseEntity<User>(this.userService.getUserByGender(gender), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "", consumes = { MediaType.APPLICATION_JSON_VALUE, "application/x-yaml" })
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO) {

        try {
            User user = this.userService.createUser(userDTO);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Cannot create user",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
