package com.minz.web.user.service;

import com.minz.web.user.UserRepository;
import com.minz.web.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;


    // 회원가입 시, 유효성 체크
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> result = userRepository.findByEmail(username);

        UserEntity userEntity = result.get();

        return new UserLoginRes(userEntity.getIdx(), userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
    }

    @Override
    public void signup(SignupDTO signupDTO) {
        UserEntity userEntity = UserEntity.builder()
                .email(signupDTO.getEmail())
                .password(passwordEncoder.encode(signupDTO.getPassword()))
                .nickname(signupDTO.getNickname())
                .build();

        userEntity.addUserRole(UserRole.USER);
        userRepository.save(userEntity);
    }

    @Override
    public void edit_homeprofile(String username, HomeprofileDTO homeprofileDTO) {

        Optional<UserEntity> result = userRepository.findByEmail(username);

        UserEntity userEntity = result.get();


        userEntity.setHousingType(homeprofileDTO.getHousingType());
        userEntity.setHouseSize(homeprofileDTO.getHouseSize());

        userRepository.save(userEntity);
    }

    @Override
    public void edit_profile(String username, ProfileDTO profileDTO) {
        Optional<UserEntity> result = userRepository.findByEmail(username);

        UserEntity userEntity = result.get();

        userEntity.setNickname(profileDTO.getNickname());
        userEntity.setMyURL(profileDTO.getMyURL());
        userEntity.setSelfIntro(profileDTO.getSelfIntro());

        userRepository.save(userEntity);
    }
}
