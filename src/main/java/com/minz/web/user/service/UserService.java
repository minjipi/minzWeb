package com.minz.web.user.service;

import com.minz.web.user.dto.HomeprofileDTO;
import com.minz.web.user.dto.ProfileDTO;
import com.minz.web.user.dto.SignupDTO;
import org.springframework.validation.Errors;

import java.util.Map;

public interface UserService {
    public Map<String, String> validateHandling(Errors errors);
    public void signup(SignupDTO signupDTO);
    public void edit_homeprofile(String username, HomeprofileDTO homeprofileDTO);
    public void edit_profile(String username, ProfileDTO profileDTO);
}