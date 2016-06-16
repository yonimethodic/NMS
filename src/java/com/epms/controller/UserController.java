/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.controller;


import com.epms.entities.AppRole;
import com.epms.entities.User;
import com.epms.json.UserResponse;

import com.epms.services.RoleService;
import com.epms.services.UserService;
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
public class UserController {

    private UserService userService;
    private RoleService roleService;


    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService us) {
        this.userService = us;
    }
    
    @Autowired(required = true)
    @Qualifier(value = "roleService")
    public void setRoleService(RoleService rs) {
        this.roleService = rs;
    }
    
    
       

    /**
     * The method called when a request to /usersGrid is made. This essentially
     * retrieves all users, which are wrapped inside a UserResponse
     * object. The object is automatically converted to JSON when returning back
     * the response. The @ResponseBody is responsible for this behavior.
     * @return UserResponse object
     */
    @RequestMapping(value = "/user/usersGrid", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public UserResponse listUsers() {

        // Retrieve all users from the service
        List<User> users = this.userService.getUsers();

        // Initialize our custom user response wrapper
        UserResponse response = new UserResponse();

        // Assign the result from the service to this response
        response.setRows(users);

        // Assign the total number of records found. This is used for paging
        response.setRecords(String.valueOf(users.size()));

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

    @RequestMapping(value = "/user/newUser", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("Roles", this.roleService.getRoles());
        
        return "admin/newUser";
    }
    
    //For adding new user
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String saveUser(@RequestParam("txtFirstName") String firstName, @RequestParam("txtLastName") String lastName,
            @RequestParam("txtUsername") String userName, @RequestParam("txtPosition") String position, @RequestParam("txtMiddleName") String middleName,
            @RequestParam("txtEmail") String email, @RequestParam("txtPassword") String password, @RequestParam(value = "ckIsActive", required = false) Boolean isActive,
            @RequestParam(value = "ckGetSMSNotification", required = false) Boolean getSMSNotification,@RequestParam(value = "ckGetEMailNotification", required = false) Boolean getEMailNotification,@RequestParam("ckRole") String[] roles) {

        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setMiddleName(middleName);
        u.setUserName(userName);
        u.setPassword(password);
        u.setEmail(email);
        u.setPosition(position);
        if(isActive == null)
            isActive = false;
        u.setIsActive(isActive);
        if(getSMSNotification == null)
            getSMSNotification = false;
        u.setsmsNotification(getSMSNotification);
        if(getEMailNotification == null)
            getEMailNotification = false;
        u.setsmsNotification(getEMailNotification);
        u.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
        
        Set<AppRole> assignedRoles = new HashSet<>();
        for (String role : roles) {
            assignedRoles.add(this.roleService.getRole(Integer.parseInt(role)));
        }
        u.setRole(assignedRoles);
        
             

        //new user, add it
        this.userService.saveUser(u);

        return "redirect:users";
    }
    
    //For adding new user
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUser(@RequestParam("id") Integer id, @RequestParam("txtFirstName") String firstName, @RequestParam("txtLastName") String lastName,
            @RequestParam("txtUsername") String userName, @RequestParam("txtPosition") String position, @RequestParam("txtMiddleName") String middleName,
            @RequestParam("txtEmail") String email, @RequestParam("txtPassword") String password, @RequestParam("ckIsActive") Boolean isActive,
            @RequestParam(value = "ckGetSMSNotification", required = false) Boolean getSMSNotification,@RequestParam(value = "ckGetEMailNotification", required = false) Boolean getEMailNotification,@RequestParam("ckRole") String[] roles) {

        User u = this.userService.getUser(id);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setMiddleName(middleName);
        u.setUserName(userName);
        u.setPassword(password);
        u.setEmail(email);
        u.setPosition(position);
        if(isActive == null)
            isActive = false;
        u.setIsActive(isActive);
        u.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
         if(getSMSNotification == null)
            getSMSNotification = false;
        u.setsmsNotification(getSMSNotification);
        if(getEMailNotification == null)
            getEMailNotification = false;
        u.setsmsNotification(getEMailNotification);
        //update roles
        u.setRole(null);
        Set<AppRole> assignedRoles = new HashSet<>();
        for (String role : roles) {
            assignedRoles.add(this.roleService.getRole(Integer.parseInt(role)));
        }
        u.setRole(assignedRoles);
        
        

        //update user
        this.userService.updateUser(u, id);

        return "redirect:users";
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = this.userService.getUser(id);
        this.userService.deleteUser(user);
        return "redirect:users";
    }

    @RequestMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        User editedUser = this.userService.getUser(id);
        model.addAttribute("user", editedUser);
        model.addAttribute("Roles", this.roleService.getRoles());
 
        return "admin/editUser";
    }
    
    
    
   
    
}
