package com.example.DateHandring.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.example.DateHandring.domain.dto.User;

import lombok.Data;

@Data
public class LoginUser extends org.springframework.security.core.userdetails.User {
    /**
     * コンストラクタ
     *
     * @param user
     * @param authorities
     */
    public LoginUser(User user, Collection<? extends GrantedAuthority> authorities){
        super(String.valueOf(user.getUserId()), user.getPassword(), authorities);
    }

}
