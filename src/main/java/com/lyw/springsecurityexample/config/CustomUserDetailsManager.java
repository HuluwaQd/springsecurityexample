package com.lyw.springsecurityexample.config;

import com.lyw.springsecurityexample.domain.SecurityUser;
import com.lyw.springsecurityexample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lyw
 * @Create 2021-03-09 15:09
 */
@Slf4j
@Component
public class CustomUserDetailsManager {
    @Resource
    private UserService userService;

    public CustomUserDetailsManager() {
        UserDetails qd = User.withUsername("qd").password("{noop}19921209").authorities(AuthorityUtils.NO_AUTHORITIES).build();
        createUser(qd);
    }

    public void createUser(UserDetails user){
        UserDetails databaseUser = userService.getUserByUserName(user.getUsername());
        if(databaseUser == null){
            userService.createUser(user);
        }else {
            log.info("已存在当前用户");
        }
    }
    public void delUser(String userName){
        userService.delUser(userName);
    }
    public void updateUser(UserDetails user){
        userService.updateUser(user);
    }
    public void changePassWord(String oldPassWord,String newPassWord) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        if(currentUser == null){
            log.info("当前用户为空");
            return;
        }

        String userName = currentUser.getName();
        UserDetails user = userService.getUserByUserName(userName);
        if(user == null){
            log.info("没有在管理器中找到对应用户");
            return;
        }
        if (!oldPassWord.equals(user.getPassword())){
            log.info("原始密码错误，无法修改密码");
            return;
        }
        SecurityUser updateUser = ((SecurityUser)user);
        updateUser.setPassWord(newPassWord);
        userService.updateUser(updateUser);
        log.info("用户：{}，修改密码成功",userName);
    }

    public Boolean userExists(String userName){
        return userService.getUserByUserName(userName)!=null?true:false;
    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { return userService.getUserByUserName(username); }
}
