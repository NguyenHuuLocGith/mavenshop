package com.example.cozastore22.controller;

import com.example.cozastore22.service.FileStorageService;
import com.example.cozastore22.service.ProductService;
import com.example.cozastore22.service.imp.FileStorageServiceImp;
import com.example.cozastore22.service.imp.ProducServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin
//@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProducServiceImp producServiceImp;

    @GetMapping("")
    public ResponseEntity<?>getProduct(){

        return new ResponseEntity<>(
                "Product Get", HttpStatus.OK);
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hello from ...";
    }

    @PostMapping("/hi")
    public String helloPost(@RequestParam String name) {
        return "Hello from Post ..." + name;
    }

    @PostMapping("")
    public ResponseEntity<?>insertProduct( @RequestParam String title,@RequestParam double price, @RequestParam int idCategory){

        System.out.println("title: " + title);

        producServiceImp.insertProduct(title,price,idCategory);
        return new ResponseEntity<>("Product Insert", HttpStatus.OK);
    }
    @GetMapping("/{tenfile}")
    public ResponseEntity<?> dowloadProductFile(@PathVariable String tenfile){
        Resource  resource = producServiceImp.downloadProductFile(tenfile);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + tenfile + "\"").body(resource);
    }

}
