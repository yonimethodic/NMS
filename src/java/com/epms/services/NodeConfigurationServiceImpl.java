/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.dao.NodeConfigurationDao;
import com.epms.entities.NodeConfiguration;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yonatan
 */
@Service
public class NodeConfigurationServiceImpl implements NodeConfigurationService {

    private NodeConfigurationDao nodeconfigurationDao;

    public void setnodeconfigurationDao(NodeConfigurationDao nodeconfigurationDao) {
        this.nodeconfigurationDao = nodeconfigurationDao;
    }
    @Override
    @Transactional
    public List getNodeconfigurations() {
        
        return this.nodeconfigurationDao.getNodeconfigurations();
    }

    @Override
    @Transactional
    public NodeConfiguration getNodeconfiguration(int Id) {
        return this.nodeconfigurationDao.getNodeconfiguration(Id);
    }

    @Override
    @Transactional
    public void saveNodeconfiguration(NodeConfiguration nodeconfiguration) {
        this.nodeconfigurationDao.saveNodeconfiguration(nodeconfiguration);
    }

    @Override
    @Transactional
    public void updateNodeconfiguration(NodeConfiguration nodeconfiguration, int id) {
        this.nodeconfigurationDao.updateNodeconfiguration(nodeconfiguration, id);
    }

   

}
