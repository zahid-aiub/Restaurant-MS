package com.workspaceit.controller.webview;


import com.workspaceit.entity.User;
import com.workspaceit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home/index");
        modelAndView.addObject("name", "Spring");
        return modelAndView;
    }

    @RequestMapping(value = "/geo")
    public ModelAndView locView(){
        ModelAndView modelAndView = new ModelAndView("home/geo_view");
        modelAndView.addObject("name", "Spring");
        return modelAndView;
    }


    @RequestMapping(value = "/populate_users")
    public ModelAndView insertDummyData(){
        userService.save(new User("Jhon", "Doe", "jhon.doe@example.com"));
        userService.save(new User("David", "Miller", "david.miller@example.com"));
        userService.save(new User("Nicol", "Kidman", "nicol.kidman@example.com"));
        userService.save(new User("Paul", "Smith", "paul.smith@example.com"));

        ModelAndView modelAndView = new ModelAndView("home/index");
        modelAndView.addObject("msg","Users Added");
        return modelAndView;
    }






}
