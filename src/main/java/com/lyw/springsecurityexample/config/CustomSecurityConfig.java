package com.lyw.springsecurityexample.config;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.annotation.Resource;

/**
 * @author lyw
 * @Create 2021-03-09 15:35
 */
@Configuration
public class CustomSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(CustomUserDetailsManager customUserDetailsManager) {
        UserDetailsManager userDetailsManager = new UserDetailsManager() {
            @Override
            public void createUser(UserDetails user) {
                customUserDetailsManager.createUser(user);
            }

            @Override
            public void updateUser(UserDetails user) {
                customUserDetailsManager.updateUser(user);
            }

            @Override
            public void deleteUser(String username) {
                customUserDetailsManager.delUser(username);
            }

            @Override
            public void changePassword(String oldPassword, String newPassword) {
                customUserDetailsManager.changePassWord(oldPassword, newPassword);
            }

            @Override
            public boolean userExists(String username) {
                return customUserDetailsManager.userExists(username);
            }

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return customUserDetailsManager.loadUserByUsername(username);
            }
        };
        return userDetailsManager;
    }
}
