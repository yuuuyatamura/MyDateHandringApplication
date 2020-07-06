package com.example.DateHandring.common.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseRealm implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UserDetails user = null;

        try {
            user = getLoginUser(email);
        }catch (Throwable e){
            throw new UsernameNotFoundException("failed to find login user.");
        }

        if(user == null){
            throw new UsernameNotFoundException("no user found. [login_id =" + email + "]");
        }
        return user;
    }

    protected abstract UserDetails getLoginUser(String email);
}
