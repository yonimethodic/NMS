/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.entities.Device;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface DeviceService {

     List getDevices();

     Device getDevice(int typeId);

    void saveDevice(Device device);

    void updateDevice(Device device, int id);

    void deleteDevice(Device device);
}
