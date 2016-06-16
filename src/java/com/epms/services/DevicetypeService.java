/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.entities.Devicetype;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface DevicetypeService {

     List getDeviceTypes();

     Devicetype getDeviceType(int typeId);

    void saveDeviceType(Devicetype devicetype);

    void updateDeviceType(Devicetype devicetype, int id);

    void deleteDeviceType(Devicetype devicetype);
}
