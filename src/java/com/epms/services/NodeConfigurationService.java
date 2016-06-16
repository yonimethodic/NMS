/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.entities.NodeConfiguration;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface NodeConfigurationService {

    
     List getNodeconfigurations();
     
     NodeConfiguration getNodeconfiguration(int nodeconfigurationId);

     void saveNodeconfiguration(NodeConfiguration nodeconfiguration);

     void updateNodeconfiguration(NodeConfiguration nodeconfiguration, int id);

    

}
