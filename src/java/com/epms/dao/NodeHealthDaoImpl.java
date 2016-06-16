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
public class NodeHealthDaoImpl extends HibernateDaoSupport implements NodeHealthDao {

    @Override
    public List getNodeHealths() {
        return getHibernateTemplate().find("from Nodehealthstatistics");
    }

   

}
