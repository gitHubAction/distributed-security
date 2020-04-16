package com.seven.distributed.uaa.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: zhangsh
 * @Date: 2020/4/16 12:11
 * @Version 1.0
 * Description
 */
@Service
public class SevenUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return User.withUsername(s).password(new BCryptPasswordEncoder().encode("123456")).authorities("r1").build();
    }
}
