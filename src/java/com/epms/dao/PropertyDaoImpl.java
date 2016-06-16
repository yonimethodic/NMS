/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;


import com.epms.entities.Property;
import java.util.List;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yonatan
 */
@Repository
public class PropertyDaoImpl extends HibernateDaoSupport implements PropertyDao {

    @Override
    public List getPropertys() {
        return getHibernateTemplate().find("from Property");
    }

    @Override
    public Property getProperty(int propertyId) {
        return (Property) getHibernateTemplate().get(Property.class, propertyId);
    }

   
    @Override
    public void updateProperty(Property property, int id) {
        property.setPropertyId(id);
        getHibernateTemplate().saveOrUpdate(property);
    }

    

}
