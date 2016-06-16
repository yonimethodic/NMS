/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.dao.AppRoleDao;
import com.epms.entities.AppRole;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yonatan
 */
@Service
public class RoleServiceImpl implements RoleService {

    private AppRoleDao roleDao;

    public void setRoleDao(AppRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List getRoles() {
        return this.roleDao.getRoles();
    }

    @Override
    @Transactional
    public AppRole getRole(int roleId) {
        return this.roleDao.getRole(roleId);
    }

    @Override
    @Transactional
    public void saveRole(AppRole role) {
        this.roleDao.saveRole(role);
    }

    @Override
    @Transactional
    public void updateRole(AppRole role, int id) {
        this.roleDao.updateRole(role, id);
    }

    @Override
    @Transactional
    public void deleteRole(AppRole role) {
        this.roleDao.deleteRole(role);
    }

}
