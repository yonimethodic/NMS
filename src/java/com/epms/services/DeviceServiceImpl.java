/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.dao.DeviceDao;
import com.epms.entities.Device;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yonatan
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceDao deviceDao;

    public void setdeviceDao(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    @Transactional
    public List getDevices() {
        return this.deviceDao.getDevices();
    }

    @Override
    @Transactional
    public Device getDevice(int deviceId) {
        return this.deviceDao.getDevice(deviceId);
    }

    @Override
    @Transactional
    public void saveDevice(Device device) {
        this.deviceDao.saveDevice(device);
    }

    @Override
    @Transactional
    public void updateDevice(Device device, int id) {
        this.deviceDao.updateDevice(device, id);
    }

    @Override
    @Transactional
    public void deleteDevice(Device device) {
        this.deviceDao.deleteDevice(device);
    }

}
