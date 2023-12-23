package com.example.cozastore22.service;

import com.example.cozastore22.entity.UserEntity;
import com.example.cozastore22.payload.request.SignUpRequest;
import com.example.cozastore22.repository.UserRepository;
import com.example.cozastore22.service.imp.UserServiceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceimp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean insertUser(SignUpRequest signUpRequest) {
        boolean isSuccess = false;
        UserEntity user =new UserEntity();
        user.setEmail(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        try {
            userRepository.save(user);
            isSuccess = true;
        }catch (Exception e)
        {
            System.out.println("Loi insert user " + e.getLocalizedMessage());
        }
        return isSuccess;
    }
}
