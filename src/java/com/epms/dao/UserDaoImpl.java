/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;


import com.epms.entities.User;
import java.util.List;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yonatan
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public List getUsers() {
        return getHibernateTemplate().find("from User");
    }

    @Override
    public User getUser(int userId) {
        return (User) getHibernateTemplate().get(User.class, userId);
    }

    @Override
    public void saveUser(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public void updateUser(User user, int id) {
        user.setId(id);
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    public void deleteUser(User user) {
        getHibernateTemplate().delete(user);
    }

    @Override
    public Boolean authenticateUser(String username, String password) {
        String queryUser = "SELECT * from user where UserName = '" + username + "' AND Password = '" + password + "'";
        SQLQuery sqlQuery = getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(queryUser);
        List result = sqlQuery.list();
        return !result.isEmpty();
    }

    @Override
    public User findByUsername(String username) {

        List<User> users = getHibernateTemplate().getSessionFactory().openSession().createQuery("from User where username=?").setParameter(0, username)
                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

  

}
