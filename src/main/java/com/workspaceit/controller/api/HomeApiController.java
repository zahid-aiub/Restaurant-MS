package com.workspaceit.controller.api;

import com.workspaceit.contents.URLPrefix;
import com.workspaceit.entity.User;
import com.workspaceit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dipanjal on 10/26/18
 **/

@RestController
@RequestMapping(value = URLPrefix.API+"/home")
public class HomeApiController {

    @Autowired
    UserService userService;

    @RequestMapping("/get_all_users")
    public Object showAllUser(){
        List<User> userList = userService.getAllUsers();
        return userList;
    }
}
