/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.controller;


import com.epms.entities.Devicetype;
import com.epms.json.DeviceTypeResponse;

import com.epms.services.DevicetypeService;
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
public class DeviceTypeController {

    private DevicetypeService devicetypeService;
    

    @Autowired(required = true)
    @Qualifier(value = "devicetypeService")
    public void setUserService(DevicetypeService us) {
        this.devicetypeService = us;
    }
    
       /**
     * The method called when a request to /usersGrid is made. This essentially
     * retrieves all users, which are wrapped inside a UserResponse
     * object. The object is automatically converted to JSON when returning back
     * the response. The @ResponseBody is responsible for this behavior.
     * @return UserResponse object
     */
    @RequestMapping(value = "/devicetype/devicetypesGrid", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public DeviceTypeResponse listDeviceTypes() {

        // Retrieve all users from the service
        List<Devicetype> devicetypes = this.devicetypeService.getDeviceTypes();

        // Initialize our custom user response wrapper
        DeviceTypeResponse response = new DeviceTypeResponse();

        // Assign the result from the service to this response
        response.setRows(devicetypes);

        // Assign the total number of records found. This is used for paging
        response.setRecords(String.valueOf(devicetypes.size()));

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

    @RequestMapping(value = "/devicetype/newDeviceType", method = RequestMethod.GET)
    public String newDeviceType(Model model) {
          return "setting/newDeviceType";
    }
    
    //For adding new Devicetype
    @RequestMapping(value = "/devicetype/add", method = RequestMethod.POST)
    public String saveDeviceType(@RequestParam("txtTypeName") String typeName) {

        Devicetype dt = new Devicetype();
        dt.setTypeName(typeName);
       //new devicetype, add it
        this.devicetypeService.saveDeviceType(dt);

        return "redirect:devicetypes";
    }
    
    //For adding new user
    @RequestMapping(value = "/devicetype/update", method = RequestMethod.POST)
    public String updateDeviceType(@RequestParam("id") Integer id, @RequestParam("txtTypeName") String typeName) {

        Devicetype dt = this.devicetypeService.getDeviceType(id);
        dt.setTypeName(typeName);
               

        //update user
        this.devicetypeService.updateDeviceType(dt, id);

        return "redirect:devicetypes";
    }

    @RequestMapping("/devicetype/delete/{id}")
    public String deleteDeviceType(@PathVariable("id") int id) {
        Devicetype devicetype = this.devicetypeService.getDeviceType(id);
        this.devicetypeService.deleteDeviceType(devicetype);
        return "redirect:devicetypes";
    }

    @RequestMapping("/devicetype/edit/{id}")
    public String editDeviceType(@PathVariable("id") int id, Model model) {
        Devicetype editeddevicetype = this.devicetypeService.getDeviceType(id);
        model.addAttribute("devicetype", editeddevicetype);
        return "setting/editDeviceType";
    }
 
}
