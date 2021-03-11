package com.lyw.springsecurityexample.controller;

import com.lyw.springsecurityexample.domain.SecurityUser;
import com.lyw.springsecurityexample.httpresponsedata.HttpResponseDataUtil;
import com.lyw.springsecurityexample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.transport.proxy.HttpReceiveSocket;

/**
 * @author lyw
 * @Create 2021-03-11 15:53
 */
@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/failure")
    public HttpResponseDataUtil.HttpResponseData failure(){
        return HttpResponseDataUtil.constructResponse(null, HttpStatus.UNAUTHORIZED.toString(),"登陆失败");
    }

    @PostMapping("/success")
    public HttpResponseDataUtil.HttpResponseData success(){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SecurityUser user = userService.getUserByUserName(principal.getUsername());
        return HttpResponseDataUtil.constructResponse(user, HttpStatus.OK.toString(),"登陆成功");
    }
}
