/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.dao.UserDao;
import com.epms.entities.AppRole;
import com.epms.entities.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yonatan
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List getUsers() {
        return this.userDao.getUsers();
    }

    @Override
    @Transactional
    public User getUser(int userId) {
        return this.userDao.getUser(userId);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        this.userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user, int id) {
        this.userDao.updateUser(user, id);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        this.userDao.deleteUser(user);
    }

    @Override
    @Transactional
    public Boolean authenticateUser(String username, String password) {
        return this.userDao.authenticateUser(username, password);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userDao.findByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

        return buildUserForAuthentication(user, authorities);
    }

    @Override
    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }

    // Converts com.epms.entities.User user to
    // org.springframework.security.core.userdetails.User
    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        org.springframework.security.core.userdetails.User authUser = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), user.getIsActive(), true, true, true, authorities);
        return authUser;
    }

    private List<GrantedAuthority> buildUserAuthority(Set<AppRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        userRoles.stream().forEach((userRole) -> {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        });

        List<GrantedAuthority> Result = new ArrayList<>(setAuths);

        return Result;
    }

}
