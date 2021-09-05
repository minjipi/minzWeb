package com.minz.web.user.service;

import com.minz.web.user.UserRepository;
import com.minz.web.user.model.SignupDTO;
import com.minz.web.user.model.UserEntity;
import com.minz.web.user.model.UserLoginReq;
import com.minz.web.user.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> result = userRepository.findByEmail(username);

        UserEntity userEntity = result.get();
        System.out.println("loadUserByUserName: " + userEntity.toString());

        UserLoginReq userLoginReq = new UserLoginReq(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRoleSet()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(
                                "ROLE_" + role.name()
                        )).collect(Collectors.toSet())
        );

        return userLoginReq;
    }

    @Override
    public void signup(SignupDTO signupDTO) {
        UserEntity userEntity = new UserEntity(new HashSet<>());

        userEntity.setEmail(signupDTO.getEmail());
        userEntity.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
        userEntity.setNickname(signupDTO.getNickname());
        userEntity.addUserRole(UserRole.USER);

        userRepository.save(userEntity);
    }
}
