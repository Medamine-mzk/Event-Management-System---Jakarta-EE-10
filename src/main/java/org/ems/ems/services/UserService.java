package org.ems.ems.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.ems.ems.models.User;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService {
    private List<User> users = new ArrayList<>();

    public void registerUser(User user) {
        users.add(user);
    }

    public User loginUser(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
