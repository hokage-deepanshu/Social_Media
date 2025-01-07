package com.user.dao;

import com.user.model.User;

public interface UserDAO {
    boolean validateUser(String username, String password);
    void saveUser(User user);
    User getUserByUsername(String username);
    User getUserById(int id); // Add the missing method
    void createUser(User user); // Ensure consistent return type
}
