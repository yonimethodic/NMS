/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;

import com.epms.entities.Device;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface DeviceDao {

    public List getDevices();

    public Device getDevice(int deviceId);

    public void saveDevice(Device device);

    public void updateDevice(Device device, int id);

    public void deleteDevice(Device device);

}
