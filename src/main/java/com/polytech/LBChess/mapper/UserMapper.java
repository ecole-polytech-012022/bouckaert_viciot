package com.polytech.LBChess.mapper;

import com.polytech.LBChess.dto.UserDTO;
import com.polytech.LBChess.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .email(user.getEmail())
                .build();
    }

    public static List<UserDTO> toUserDTOList(List<User> list) {
        List<UserDTO> dtoList = new ArrayList<>();
        for (User user : list) {
            dtoList.add(toUserDTO(user));
        }
        return dtoList;
    }

    public static User toUser(UserDTO dto) {
        return User.builder()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .email(dto.getEmail())
                .build();
    }

    public static List<User> toUserList(List<UserDTO> list) {
        List<User> userList = new ArrayList<>();
        for (UserDTO dto : list) {
            userList.add(toUser(dto));
        }
        return userList;
    }

}
