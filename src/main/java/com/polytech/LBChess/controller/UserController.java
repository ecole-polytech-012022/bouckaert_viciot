package com.polytech.LBChess.controller;

import com.polytech.LBChess.model.User;
import com.polytech.LBChess.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByName(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);

        if(user != null) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        if (createdUser != null)  {
            return ResponseEntity.ok(createdUser);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserByName(@PathVariable Integer userId) {
        if (userService.deleteUser(userId)) {
            return ResponseEntity.ok("User successfully removed");
        }
        return ResponseEntity.notFound().build();
    }
}
