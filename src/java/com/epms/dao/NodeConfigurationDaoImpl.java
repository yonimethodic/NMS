/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;


import com.epms.entities.NodeConfiguration;
import java.util.List;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yonatan
 */
@Repository
public class NodeConfigurationDaoImpl extends HibernateDaoSupport implements NodeConfigurationDao {

    @Override
    public List getNodeconfigurations() {
        return getHibernateTemplate().find("from NodeConfiguration");
    }
    
    @Override
    public NodeConfiguration getNodeconfiguration(int Id) {
        return (NodeConfiguration) getHibernateTemplate().get(NodeConfiguration.class,Id);
    }

    @Override
    public void saveNodeconfiguration(NodeConfiguration nodeconfiguration) {
        getHibernateTemplate().save(nodeconfiguration);
    }

    @Override
    public void updateNodeconfiguration(NodeConfiguration nodeconfiguration, int id) {
        nodeconfiguration.setId(id);
        getHibernateTemplate().saveOrUpdate(nodeconfiguration);
    }

   

}
