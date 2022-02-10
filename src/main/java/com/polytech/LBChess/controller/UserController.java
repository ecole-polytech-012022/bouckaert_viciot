package com.polytech.LBChess.controller;

import com.polytech.LBChess.dto.UserDTO;
import com.polytech.LBChess.mapper.UserMapper;
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
    public ResponseEntity<List<UserDTO>> getAllUsers()
    {
        List<User> users = userService.getAllUsers();
        List<UserDTO> usersDtos = UserMapper.toUserDTOList(users);

        return ResponseEntity.ok(usersDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        UserDTO userDTO = UserMapper.toUserDTO(user);

        if(user != null) {
            return ResponseEntity.ok(userDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        UserDTO createdUserDto = UserMapper.toUserDTO(createdUser);
        if (createdUser != null)  {
            return ResponseEntity.ok(createdUserDto);
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
