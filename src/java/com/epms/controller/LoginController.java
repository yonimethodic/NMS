/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epms.controller;

import com.epms.services.UserService;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Yonatan
 */
@Controller
public class LoginController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService us) {
        this.userService = us;
    }

    @RequestMapping(value = "index/login", method = RequestMethod.POST)
    public String loginPage(@RequestParam(value = "error") Boolean error, Model model) {

        if (error == true) {
            // Assign an error message
            model.addAttribute("error", "Invalid username or password!");
        } else {
            model.addAttribute("error", "");
        }

        return "index";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            model.addAttribute("user", ((UserDetails) principal).getUsername());
            System.out.println("User has authorities " + ((UserDetails) principal).getAuthorities());
        } else {
            model.addAttribute("user", principal);            
        }
        //model.addAttribute("message", messageService.getMessage());
        return "dashboard/dashboard";
    }
}
