package com.minz.web.user.controller;

import com.minz.web.config.JwtTokenUtil;
import com.minz.web.user.dto.*;
import com.minz.web.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserServiceImpl userService;

//    @GetMapping("/login")
//    public void login() {
//    }
//
//    @GetMapping("/signup")
//    public void signup_get() {
//
//    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginReq userLoginReq) throws Exception {

        Authentication authentication = authenticate(userLoginReq.getEmail(), userLoginReq.getPassword());
        UserLoginRes userLoginRes = (UserLoginRes) authentication.getPrincipal();

        final String token = jwtTokenUtil.generateToken(userLoginRes);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

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
