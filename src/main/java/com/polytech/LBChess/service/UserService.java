package com.polytech.LBChess.service;

import com.polytech.LBChess.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public void initUsers() {
        User user1 = new User();
        user1.setNom("Dupond");
        user1.setPrenom("Henri");
        user1.setEmail("henri.dupond@laposte.net");

        User user2 = new User();
        user2.setNom("Durand");
        user2.setPrenom("Paul");
        user2.setEmail("paul.durand@orange.fr");

        users.add(user1);
        users.add(user2);
    }

    public List<User> getAllUsers() {
        if(this.users.isEmpty())
            this.initUsers();

        return this.users;
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

    public User createUser(User givenUser) {
        if(givenUser.getNom() != null && givenUser.getPrenom() != null && givenUser.getEmail() != null) {
            this.users.add(givenUser);
            return givenUser;
        }
        return null;
    }

    public boolean deleteUserByName(String userName) {
        for(User user : this.users){
            if(user.getNom().equals(userName)) {
                users.remove(user);
                return true;
            }
        }
        return false;

    }
}
