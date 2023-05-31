package it.altaformazione.foodmemongo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.altaformazione.foodmemongo.models.User;
import it.altaformazione.foodmemongo.models.dtos.OrderDTO;
import it.altaformazione.foodmemongo.models.dtos.UserDTO;
import it.altaformazione.foodmemongo.services.interfaces.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> users() {

        return new ResponseEntity<List<User>>(
                this.userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> user(@PathVariable String id) {

        try {
            return new ResponseEntity<UserDTO>(
                    this.userService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public ResponseEntity<?> userByGender(@PathVariable String gender,
            @PathVariable int age) {

        try {
            return new ResponseEntity<List<UserDTO>>(
                    this.userService.getUserByGender(gender, age), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<?> userByGender(@PathVariable String id) {

        try {
            List<OrderDTO> orderDTOs = this.userService.getUserOrders(id);
            if (orderDTOs.size() > 0) {
                return new ResponseEntity<List<OrderDTO>>(
                        orderDTOs, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("No order found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>("No order found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<User> users(@RequestBody UserDTO userDTO) {

        return new ResponseEntity<User>(
                this.userService.create(userDTO), HttpStatus.OK);
    }

}
