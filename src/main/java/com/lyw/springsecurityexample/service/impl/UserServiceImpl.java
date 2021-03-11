package com.lyw.springsecurityexample.service.impl;

import com.lyw.springsecurityexample.mapper.UserMapper;
import com.lyw.springsecurityexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
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
    public UserDetails getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
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
}
