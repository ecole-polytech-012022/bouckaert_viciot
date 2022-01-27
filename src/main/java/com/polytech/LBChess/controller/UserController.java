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

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable String userName) {
        User user = userService.getUserByName(userName);

        if(!user.isNull())
            return ResponseEntity.ok(user);

        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        if (!createdUser.isNull()) {
            return ResponseEntity.ok(createdUser);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<String> deleteUserByName(@PathVariable String userName) {
        if (userService.deleteUserByName(userName)) {
            return ResponseEntity.ok("User successfuly removed");
        }
        return ResponseEntity.notFound().build();
    }
}