/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.dao;

import com.epms.entities.NodeConfiguration;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface NodeConfigurationDao {

    
    public List getNodeconfigurations();
    
    public NodeConfiguration getNodeconfiguration(int nodeconfigurationId);

    public void saveNodeconfiguration(NodeConfiguration nodeconfiguration);

    public void updateNodeconfiguration(NodeConfiguration nodeconfiguration, int id);

    

}
