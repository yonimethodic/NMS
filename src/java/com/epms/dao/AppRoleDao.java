/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;

import com.epms.entities.AppRole;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface AppRoleDao {

    public List getRoles();

    public AppRole getRole(int roleId);

    public void saveRole(AppRole role);

    public void updateRole(AppRole role, int id);

    public void deleteRole(AppRole role);

}
