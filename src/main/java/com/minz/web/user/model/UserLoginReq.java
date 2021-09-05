package com.minz.web.user.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserLoginReq extends User {
    String email;
    String password;

    public UserLoginReq(String username, String password, Collection<?
            extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
    }
}
