package com.polytech.LBChess.service;

import com.polytech.LBChess.model.User;
import com.polytech.LBChess.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.initUsers();
    }

    public void initUsers() {
        User user1 = new User();
        user1.setNom("Dupond");
        user1.setPrenom("Henri");
        user1.setEmail("henri.dupond@laposte.net");

        User user2 = new User();
        user2.setNom("Durand");
        user2.setPrenom("Paul");
        user2.setEmail("paul.durand@orange.fr");

        User user3 = new User();
        user3.setNom("Durant");
        user3.setPrenom("Pauline");
        user3.setEmail("pauline.durant@orange.fr");

        this.repository.save(user1);
        this.repository.save(user2);
        this.repository.save(user3);
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> found = this.repository.findById(id);

        return found.orElse(null);
    }

    public User createUser(User givenUser) {
        if (givenUser.getNom() != null && givenUser.getEmail() != null && givenUser.getPrenom() != null) {
            return this.repository.save(givenUser);
        }
        return null;
    }

    public boolean deleteUser(Integer userId) {
        User found = getUserById(userId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }
}
