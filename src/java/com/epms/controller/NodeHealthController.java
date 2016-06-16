package com.epms.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.epms.entities.Nodehealthstatistics;
import com.epms.json.NodeHealthResponse;

import com.epms.services.NodeHealthService;
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
public class NodeHealthController {

    private NodeHealthService nodehealthService;
    

    @Autowired(required = true)
    @Qualifier(value = "nodehealthService")
    public void setUserService(NodeHealthService NHS) {
        this.nodehealthService = NHS;
    }
    
       /**
     * The method called when a request to /usersGrid is made. This essentially
     * retrieves all users, which are wrapped inside a UserResponse
     * object. The object is automatically converted to JSON when returning back
     * the response. The @ResponseBody is responsible for this behavior.
     * @return UserResponse object
     */
    @RequestMapping(value = "/nodehealth/nodehealthsGrid", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public NodeHealthResponse listNodeHealths() {

        // Retrieve all users from the service
        List<Nodehealthstatistics> nodehealthstatistics = this.nodehealthService.getNodeHealths();

        // Initialize our custom user response wrapper
        NodeHealthResponse response = new NodeHealthResponse();

        // Assign the result from the service to this response
        response.setRows(nodehealthstatistics);

        // Assign the total number of records found. This is used for paging
        response.setRecords(String.valueOf(nodehealthstatistics.size()));

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

 
}
