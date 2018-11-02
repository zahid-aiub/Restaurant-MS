package com.workspaceit.controller.api;

import com.workspaceit.contents.URLPrefix;
import com.workspaceit.entity.User;
import com.workspaceit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dipanjal on 10/26/18
 **/

@CrossOrigin
@RestController
@RequestMapping(value = URLPrefix.API+"/home")
public class HomeApiController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/all")
    public Object showAllUser(){
        List<User> userList = userService.getAllUsers();
        return userList;
    }

    @RequestMapping("/user/{email}")
    public Object getUserByEmai(@PathVariable String email){
        List<User> userList = userService.getAllUsers();
        return userList;
    }
}
