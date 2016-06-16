/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;

import com.epms.entities.Devicetype;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface DevicetypeDao {

    public List getDeviceTypes();

    public Devicetype getDeviceType(int devicetypeId);

    public void saveDeviceType(Devicetype devicetype);

    public void updateDeviceType(Devicetype devicetype, int id);

    public void deleteDeviceType(Devicetype role);

}
