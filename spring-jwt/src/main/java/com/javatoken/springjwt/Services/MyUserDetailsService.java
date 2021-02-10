package com.javatoken.springjwt.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    // make the repository then it will make the multiple user to authenticate
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return  new User("jin", "jin", new ArrayList<>());
    }
}
