package com.example.cozastore22.controller;

import com.example.cozastore22.payload.response.BaseResponse;
import com.example.cozastore22.payload.response.CategoryResponse;
import com.example.cozastore22.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;
    @GetMapping("")
    public ResponseEntity<?> getCatefory(){
        List<CategoryResponse> list = categoryServiceImp.getAllCategory();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(list);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
