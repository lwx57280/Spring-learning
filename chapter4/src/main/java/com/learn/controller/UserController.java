package com.learn.controller;

import com.learn.domain.User;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    @Qualifier("myUserService")
    private UserService userService;

    public User getUserById(Integer id){
        return userService.getUserById(id);
    }

   /* public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/
}
