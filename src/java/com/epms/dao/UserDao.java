/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;

import com.epms.entities.User;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface UserDao {

    public List getUsers();

    public User getUser(int userId);

    public void saveUser(User user);

    public void updateUser(User user, int id);

    public void deleteUser(User user);
    
    public Boolean authenticateUser(String username, String password);

    public User findByUsername(String username);
    
   

}
