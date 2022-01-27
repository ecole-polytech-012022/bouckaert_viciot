package com.polytech.LBChess.service;

import com.polytech.LBChess.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getAllUsers() {
        User user1 = new User();
        user1.setNom("Dupond");
        user1.setPrenom("Henri");
        user1.setEmail("henri.dupond@laposte.net");

        User user2 = new User();
        user2.setNom("Durand");
        user2.setPrenom("Paul");
        user2.setEmail("paul.durand@orange.fr");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        return list;
    }

    public User getUserByName(String userName) {
        List<User> users = this.getAllUsers();

        for(User user : users){
            if(user.getNom().equals(userName)) {
                return user;
            }
        }

        return null;
    }
}
