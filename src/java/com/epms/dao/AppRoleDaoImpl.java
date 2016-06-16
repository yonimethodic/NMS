/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;

import com.epms.entities.AppRole;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yonatan
 */
@Repository
public class AppRoleDaoImpl extends HibernateDaoSupport implements AppRoleDao {

    @Override
    public List getRoles() {
        return getHibernateTemplate().find("from AppRole");
    }

    @Override
    public AppRole getRole(int roleId) {
        return (AppRole) getHibernateTemplate().get(AppRole.class, roleId);
    }

    @Override
    public void saveRole(AppRole role) {
        getHibernateTemplate().save(role);
    }

    @Override
    public void updateRole(AppRole role, int id) {
        role.setId(id);
        getHibernateTemplate().saveOrUpdate(role);
    }

    @Override
    public void deleteRole(AppRole role) {
        getHibernateTemplate().delete(role);
    }

}
