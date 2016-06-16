/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.entities.AppRole;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface RoleService {

    List getRoles();

    AppRole getRole(int roleId);

    void saveRole(AppRole role);

    void updateRole(AppRole role, int id);

    void deleteRole(AppRole role);
}
