/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.dao.DevicetypeDao;
import com.epms.entities.Devicetype;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yonatan
 */
@Service
public class DevicetypeServiceImpl implements DevicetypeService {

    private DevicetypeDao devicetypeDao;

    public void setdevicetypeDao(DevicetypeDao devicetypeDao) {
        this.devicetypeDao = devicetypeDao;
    }

    @Override
    @Transactional
    public List getDeviceTypes() {
        return this.devicetypeDao.getDeviceTypes();
    }

    @Override
    @Transactional
    public Devicetype getDeviceType(int devicetypeId) {
        return this.devicetypeDao.getDeviceType(devicetypeId);
    }

    @Override
    @Transactional
    public void saveDeviceType(Devicetype devicetype) {
        this.devicetypeDao.saveDeviceType(devicetype);
    }

    @Override
    @Transactional
    public void updateDeviceType(Devicetype devicetype, int id) {
        this.devicetypeDao.updateDeviceType(devicetype, id);
    }

    @Override
    @Transactional
    public void deleteDeviceType(Devicetype devicettype) {
        this.devicetypeDao.deleteDeviceType(devicettype);
    }

}
