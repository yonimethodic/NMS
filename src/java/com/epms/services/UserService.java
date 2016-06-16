/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.entities.User;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface UserService {

    List getUsers();

    User getUser(int userId);

    void saveUser(User user);

    void updateUser(User user, int id);

    void deleteUser(User user);
    
    Boolean authenticateUser(String username, String password);
    
    User findByUsername(String username);
    
}
