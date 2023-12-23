package com.example.cozastore22.service.imp;

import com.example.cozastore22.payload.request.SignUpRequest;
import com.example.cozastore22.payload.response.CategoryResponse;

import java.util.List;

public interface UserServiceimp {
    boolean insertUser(SignUpRequest signUpRequest);
}
