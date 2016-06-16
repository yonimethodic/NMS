/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;


import com.epms.entities.Devicetype;
import java.util.List;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yonatan
 */
@Repository
public class DevicetypeDaoImpl extends HibernateDaoSupport implements DevicetypeDao {

    @Override
    public List getDeviceTypes() {
        return getHibernateTemplate().find("from Devicetype");
    }

    @Override
    public Devicetype getDeviceType(int deviceId) {
        return (Devicetype) getHibernateTemplate().get(Devicetype.class, deviceId);
    }

    @Override
    public void saveDeviceType(Devicetype devicetype) {
        getHibernateTemplate().save(devicetype);
    }

    @Override
    public void updateDeviceType(Devicetype devicetype, int id) {
        devicetype.setId(id);
        getHibernateTemplate().saveOrUpdate(devicetype);
    }

    @Override
    public void deleteDeviceType(Devicetype devicetype) {
        getHibernateTemplate().delete(devicetype);
    }

}
