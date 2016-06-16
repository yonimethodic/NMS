/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;


import com.epms.entities.Device;
import java.util.List;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yonatan
 */
@Repository
public class DeviceDaoImpl extends HibernateDaoSupport implements DeviceDao {

    @Override
    public List getDevices() {
        return getHibernateTemplate().find("from Device");
    }

    @Override
    public Device getDevice(int deviceId) {
        return (Device) getHibernateTemplate().get(Device.class, deviceId);
    }

    @Override
    public void saveDevice(Device device) {
        getHibernateTemplate().save(device);
    }

    @Override
    public void updateDevice(Device device, int id) {
        device.setId(id);
        getHibernateTemplate().saveOrUpdate(device);
    }

    @Override
    public void deleteDevice(Device device) {
        getHibernateTemplate().delete(device);
    }

}
