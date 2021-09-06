package com.minz.web.user.service;

import com.minz.web.user.model.HomeprofileDTO;
import com.minz.web.user.model.SignupDTO;

public interface UserService {
    public void signup(SignupDTO signupDTO);
    public void edit_homeprofile(String username, HomeprofileDTO homeprofileDTO);
}