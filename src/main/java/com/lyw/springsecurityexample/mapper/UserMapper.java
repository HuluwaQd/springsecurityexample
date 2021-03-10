package com.lyw.springsecurityexample.mapper;

import com.lyw.springsecurityexample.domain.SecurityUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

/**
 * @author lyw
 * @Create 2021-03-10 9:45
 */
@Repository
public interface UserMapper {

    SecurityUser getUserByUserName(@Param("userName") String userName);

    void createUser(@Param("bean")UserDetails user);

    void delUser(@Param("userName")String userName);

    void updateUser(@Param("bean")UserDetails user);
}
