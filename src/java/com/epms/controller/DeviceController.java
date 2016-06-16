/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.controller;


import com.epms.entities.Device;
import com.epms.json.DeviceResponse;
import com.epms.services.DevicetypeService;
import com.epms.services.DeviceService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class DeviceController {

    private DeviceService deviceService;
    private DevicetypeService devicetypeservice;

    @Autowired(required = true)
    @Qualifier(value = "deviceService")
    public void setUserService(DeviceService us) {
        this.deviceService = us;
    }
     @Autowired(required = true)
    @Qualifier(value = "devicetypeService")
    public void setDevicetypeService(DevicetypeService dt) {
        this.devicetypeservice = dt;
    }
       /**
     * The method called when a request to /usersGrid is made. This essentially
     * retrieves all users, which are wrapped inside a UserResponse
     * object. The object is automatically converted to JSON when returning back
     * the response. The @ResponseBody is responsible for this behavior.
     * @return UserResponse object
     */
    @RequestMapping(value = "/device/devicesGrid", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public DeviceResponse listDevices() {

        // Retrieve all users from the service
        List<Device> devices = this.deviceService.getDevices();

        // Initialize our custom user response wrapper
        DeviceResponse response = new DeviceResponse();

        // Assign the result from the service to this response
        response.setRows(devices);

        // Assign the total number of records found. This is used for paging
        response.setRecords(String.valueOf(devices.size()));

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

    @RequestMapping(value = "/device/newDevice", method = RequestMethod.GET)
    public String newDevice(Model model) {
        model.addAttribute("Devicetypes", this.devicetypeservice.getDeviceTypes());
          return "setting/newDevice";
    }
    
    //For adding new Device
    @RequestMapping(value = "/device/add", method = RequestMethod.POST)
    public String saveDevice(@RequestParam("txtSerialNumber") String serialNumber,@RequestParam("txtSeculededPreventiveMaintenaceDate") String SeculededPreventiveMaintenaceDate,@RequestParam("txtLastMaintenanceDate") String LastMaintenanceDate,@RequestParam("txtTestingPoint") String testingPoint,@RequestParam("slctDevicetype") Integer devicetypeId) throws ParseException {
        SimpleDateFormat format; //= new SimpleDateFormat("yyyy-MM-dd");
         format = new SimpleDateFormat("dd/MM/yyyy");
        Device dt = new Device();
        dt.setSerialNumber(serialNumber);
        dt.setDevicetypeId(devicetypeId);
        dt.setTestingPoint(testingPoint);
        if (!"".equals(SeculededPreventiveMaintenaceDate))
        {
            
        java.util.Date parsedSeculededPreventiveMaintenaceDate =  format.parse(SeculededPreventiveMaintenaceDate);
        dt.setSeculededPreventiveMaintenaceDate(new Date(parsedSeculededPreventiveMaintenaceDate.getTime()));
        }
        if (!"".equals(LastMaintenanceDate))
        {
        java.util.Date parsedLastMaintenanceDate = format.parse(LastMaintenanceDate);
        dt.setLastMaintenanceDate(new Date(parsedLastMaintenanceDate.getTime()));
        }
       //new devicetype, add it
        this.deviceService.saveDevice(dt);

        return "redirect:devices";
    }
    
    //For adding new user
    @RequestMapping(value = "/device/update", method = RequestMethod.POST)
    public String updateDevice(@RequestParam("id") Integer id, @RequestParam("txtSerialNumber") String serialNumber,@RequestParam("txtSeculededPreventiveMaintenaceDate") String SeculededPreventiveMaintenaceDate,@RequestParam("txtLastMaintenanceDate") String LastMaintenanceDate,@RequestParam("slctDevicetype") Integer devicetypeId,@RequestParam("txtTestingPoint") String testingPoint) throws ParseException {
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Device dt = this.deviceService.getDevice(id);
        dt.setSerialNumber(serialNumber);
        dt.setDevicetypeId(devicetypeId);
        dt.setTestingPoint(testingPoint);
        if (!"".equals(SeculededPreventiveMaintenaceDate))
        {
        java.util.Date parsedSeculededPreventiveMaintenaceDate = format.parse(SeculededPreventiveMaintenaceDate);
        dt.setSeculededPreventiveMaintenaceDate(new Date(parsedSeculededPreventiveMaintenaceDate.getTime()));
        }
        if (!"".equals(LastMaintenanceDate))
        {
        java.util.Date parsedLastMaintenanceDate = format.parse(LastMaintenanceDate);
        dt.setLastMaintenanceDate(new Date(parsedLastMaintenanceDate.getTime()));
        }

        //update user
        this.deviceService.updateDevice(dt, id);

       return "redirect:devices";
    }

    @RequestMapping("/device/delete/{id}")
    public String deleteDevice(@PathVariable("id") int id) {
        Device device = this.deviceService.getDevice(id);
        this.deviceService.deleteDevice(device);
        return "redirect:devices";
    }

    @RequestMapping("/device/edit/{id}")
    public String editDeviceType(@PathVariable("id") int id, Model model) {
        Device editeddevice = this.deviceService.getDevice(id);
        model.addAttribute("Devicetypes", this.devicetypeservice.getDeviceTypes());
        model.addAttribute("device", editeddevice);
        return "setting/editDevice";
    }
 
}
