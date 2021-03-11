package com.lyw.springsecurityexample.service.impl;

import com.lyw.springsecurityexample.domain.SecurityUser;
import com.lyw.springsecurityexample.mapper.UserMapper;
import com.lyw.springsecurityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


/**
 * @author lyw
 * @Create 2021-03-10 9:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 查询用户
     *
     * @param userName
     * @return
     */
    @Override
    public SecurityUser getUserByUserName(String userName) {
        SecurityUser userByUserName = userMapper.getUserByUserName(userName);
        return userByUserName;
    }

    /**
     * 创建用户
     *
     * @param user
     */
    @Override
    public void createUser(UserDetails user) {
        userMapper.createUser(user);
    }

    /**
     * 删除用户
     *
     * @param userName
     */
    @Override
    public void delUser(String userName) {
        userMapper.delUser(userName);
    }

    /**
     * 更新用户
     *
     * @param user
     */
    @Override
    public void updateUser(UserDetails user) {
        userMapper.updateUser(user);
    }

    /**
     * 根据用户名称加载security用户
     *
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        SecurityUser userByUserName = userMapper.getUserByUserName(username);
        UserDetails user = User.withUsername(userByUserName.getUsername()).password(userByUserName.getPassword()).authorities(AuthorityUtils.NO_AUTHORITIES).build();
        return user;
    }
}
