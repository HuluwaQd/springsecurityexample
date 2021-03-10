package com.lyw.springsecurityexample.controller;

import com.lyw.springsecurityexample.domain.SecurityUser;
import com.lyw.springsecurityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lyw
 * @Create 2021-03-08 14:27
 */
@RestController
@RequestMapping("/user")
public class SecurityController {
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String security(){
        return "test";
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody SecurityUser user){
        userService.createUser(user);
    }
    @PutMapping("/updateUser")
    public void updateUser(@RequestBody SecurityUser user){
        userService.updateUser(user);
    }
    @DeleteMapping("/delUser")
    public void delUser(@RequestParam("userName") String userName){
        userService.delUser(userName);
    }
    @GetMapping("/queryUser")
    public SecurityUser queryUser(@RequestParam("userName") String userName){
        return (SecurityUser)userService.getUserByUserName(userName);
    }
}
