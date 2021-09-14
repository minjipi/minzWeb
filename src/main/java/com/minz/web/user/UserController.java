package com.minz.web.user;

import com.minz.web.user.model.HomeprofileDTO;
import com.minz.web.user.model.ProfileDTO;
import com.minz.web.user.model.SignupDTO;
import com.minz.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("/login")
//    public void login() {
//    }
//
//    @GetMapping("/signup")
//    public void signup_get() {
//
//    }

    @PostMapping("/signup")
    public String signup_post(@Valid @RequestBody SignupDTO signupDTO, Errors errors, Model model) {

        if (errors.hasErrors()) {
            // 회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("signupDTO", signupDTO);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                System.out.println("Error [" + key + "] : " + validatorResult.get(key));
                model.addAttribute(key, validatorResult.get(key));
            }

//            return "/user/signup";
            return "회원 가입 실패 ";
        }

        System.out.println("-------------" + signupDTO.toString());
        userService.signup(signupDTO);
//        return "redirect:/user/login";
        return "회원 가입 성공 ";
    }

//    @GetMapping("/homeprofile")
//    public void homeprofile() {
//    }

    @PostMapping("/homeprofile")
    public void edit_homeprofile(Principal principal, @RequestBody HomeprofileDTO homeprofileDTO) {
        System.out.println(homeprofileDTO.toString());
        String username = principal.getName();
        userService.edit_homeprofile(username, homeprofileDTO);

    }

//    @GetMapping("/profile")
//    public void profile() {
//    }

    @PostMapping("/profile")
    public void edit_profile(Principal principal, @RequestBody ProfileDTO profileDTO) {
        System.out.println(profileDTO.toString());
        String username = principal.getName();
        userService.edit_profile(username, profileDTO);
    }
}
