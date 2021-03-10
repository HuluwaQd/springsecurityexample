package com.lyw.springsecurityexample.service;

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
    UserDetails getUserByUserName(String userName);

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
}
