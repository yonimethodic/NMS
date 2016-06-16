/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.services;

import com.epms.entities.Property;
import java.util.List;

/**
 *
 * @author Yonatan
 */
public interface PropertyService {

     List getPropertys();

    Property getProperty(int Id);
    
    void updateProperty(Property property, int id);

    
}
