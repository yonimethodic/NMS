/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.dao.PropertyDao;
import com.epms.entities.Property;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yonatan
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyDao propertyDao;

    public void setpropertyDao(PropertyDao PODao) {
        this.propertyDao = PODao;
    }

    @Override
    @Transactional
    public List getPropertys() {
        return this.propertyDao.getPropertys();
    }

    @Override
    @Transactional
    public Property getProperty(int Id) {
        return this.propertyDao.getProperty(Id);
    }

   

    @Override
    @Transactional
    public void updateProperty(Property property, int id) {
        this.propertyDao.updateProperty(property, id);
    }



}
