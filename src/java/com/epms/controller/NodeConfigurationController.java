/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.controller;


import com.epms.entities.NodeConfiguration;
import com.epms.json.NodeConfigurationResponse;

import com.epms.services.NodeConfigurationService;
import com.google.gson.Gson;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Yonatan
 */
@Controller
public class NodeConfigurationController {

    private NodeConfigurationService nodeconfigurationService;
    

    @Autowired(required = true)
    @Qualifier(value = "nodeconfigurationService")
    public void setNodeconfigurationService(NodeConfigurationService nd) {
        this.nodeconfigurationService = nd;
    }
    
    @RequestMapping(value = "/nodeconfiguration/nodeconfigurationsGrid", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public NodeConfigurationResponse listNodeconfigurations() {

        // Retrieve all users from the service
        List<NodeConfiguration> nodeconfigurations = this.nodeconfigurationService.getNodeconfigurations();

        // Initialize our custom user response wrapper
        NodeConfigurationResponse response = new NodeConfigurationResponse();

        // Assign the result from the service to this response
        response.setRows(nodeconfigurations);

        // Assign the total number of records found. This is used for paging
        response.setRecords(String.valueOf(nodeconfigurations.size()));

        // Since our service is just a simple service for teaching purposes
        // We didn't really do any paging. But normally your DAOs or your persistence layer should support this
        // Assign a dummy page
        response.setPage("1");

        // Same. Assign a dummy total pages
        response.setTotal("10");

        // Return the response
        // Spring will automatically convert our UserResponse as JSON object. 
        // This is triggered by the @ResponseBody annotation. 
        // It knows this because the JqGrid has set the headers to accept JSON format when it made a request
        // Spring by default uses Jackson to convert the object to JSON
        return response;
    }
    @RequestMapping(value = "/nodeconfiguration/newNodeconfiguration", method = RequestMethod.GET)
    public String newnewNodeconfiguration(Model model) {
          return "setting/newNodeconfiguration";
    }
    
    //For adding new NodeConfiguration
    @RequestMapping(value = "/nodeconfiguration/add", method = RequestMethod.POST)
    public String saveNodeconfiguration(@RequestParam("txtCountry") String country,@RequestParam("txtProvince") String province,@RequestParam("txtDistrict") String district,@RequestParam("txtFacility") String facility) {

        NodeConfiguration dt = new NodeConfiguration();
        dt.setCountry(country);
        dt.setProvince(province);
        dt.setDistrict(district);
        dt.setFacility(facility);
        
       //new NodeNotification, add it
        this.nodeconfigurationService.saveNodeconfiguration(dt);

        return "redirect:nodeconfigurations";
    }
    
    //For adding new user
    @RequestMapping(value = "/nodeconfiguration/update", method = RequestMethod.POST)
    public String updateNodeconfiguration(@RequestParam("id") Integer id, @RequestParam("txtCountry") String country,@RequestParam("txtProvince") String province,@RequestParam("txtDistrict") String district,@RequestParam("txtFacility") String facility) {

        NodeConfiguration dt = this.nodeconfigurationService.getNodeconfiguration(id);
        dt.setCountry(country);
        dt.setProvince(province);
        dt.setDistrict(district);
        dt.setFacility(facility);
               

        //update NodeConfiguration
        this.nodeconfigurationService.updateNodeconfiguration(dt, id);

        return "redirect:nodeconfigurations";
    }

  
    @RequestMapping("/nodeconfiguration/edit/")
    public String editNodeconfiguration(@PathVariable("id") int id, Model model) {
        NodeConfiguration editedNodeconfiguration = this.nodeconfigurationService.getNodeconfiguration(id);
        model.addAttribute("Nodeconfiguration", editedNodeconfiguration);
        return "setting/editNodeconfiguration";
    }
 
}
