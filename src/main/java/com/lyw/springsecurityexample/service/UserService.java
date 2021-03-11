package com.lyw.springsecurityexample.service;

import com.lyw.springsecurityexample.domain.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author lyw
 * @Create 2021-03-10 9:43
 */
public interface UserService {
    /**
     * 查询用户
     * @param userName
     * @return
     */
    SecurityUser getUserByUserName(String userName);

    /**
     * 创建用户
     * @param user
     */
    void createUser(UserDetails user);

    /**
     * 删除用户
     * @param userName
     */
    void delUser(String userName);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(UserDetails user);

    /**
     * 根据用户名称加载security用户
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);
}
