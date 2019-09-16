package com.example.notesystem.api.controllers;


import com.example.notesystem.business.domains.UserProfile;
import com.example.notesystem.business.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/userapi")
public class UserController {

    @Autowired
    private UserService userService; //autowire dependency for this controller

    @RequestMapping(produces = "userprofile/json", method = RequestMethod.GET, value = "/info")
    @ResponseBody
    public UserProfile getUserProfile(@RequestHeader(value="UserAuth") String userAuth) {
        return this.userService.getUserProfile(userAuth);
    }

}
