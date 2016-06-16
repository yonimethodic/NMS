/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.dao.NodeHealthDao;
import com.epms.entities.Nodehealthstatistics;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yonatan
 */
@Service
public class NodeHealthServiceImpl implements NodeHealthService {

    private NodeHealthDao nodehealthDao;

    public void setnodehealthDao(NodeHealthDao nodeHealthDao) {
        this.nodehealthDao = nodeHealthDao;
    }

    @Override
    @Transactional
    public List getNodeHealths() {
        return this.nodehealthDao.getNodeHealths();
    }

}
