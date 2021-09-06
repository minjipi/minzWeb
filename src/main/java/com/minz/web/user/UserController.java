package com.minz.web.user;

import com.minz.web.user.model.HomeprofileDTO;
import com.minz.web.user.model.SignupDTO;
import com.minz.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/signup")
    public void signup_get() {

    }

    @GetMapping("/homeprofile")
    public void homeprofile() {

    }

    @PostMapping("/homeprofile")
    public void edit_homeprofile(HomeprofileDTO homeprofileDTO){
        System.out.println(homeprofileDTO.toString());
    }


    @PostMapping("/signup")
    public String signup_post(SignupDTO signupDTO) {
        System.out.println("-------------" + signupDTO.toString());
        userService.signup(signupDTO);
        return "redirect:/user/login";
    }

}
