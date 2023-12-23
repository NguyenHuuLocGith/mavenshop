package com.example.cozastore22.service;

import com.example.cozastore22.entity.CategoryEntity;
import com.example.cozastore22.entity.ProductEntity;
import com.example.cozastore22.repository.ProductRespository;
import com.example.cozastore22.service.imp.FileStorageServiceImp;
import com.example.cozastore22.service.imp.ProducServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ProductService implements ProducServiceImp {
    @Autowired
    private FileStorageServiceImp fileStorageServiceImp;

    @Autowired
    private ProductRespository productRespository;

    @Value("${path.upload.file}")
    private String folderRoot;
    Path root;
    @Override
    public boolean insertProduct( String title, double prices, int idCategory) {




            CategoryEntity category = new CategoryEntity();
            ProductEntity product = new ProductEntity();
            product.setPrice(prices);
            product.setTitle(title);

            category.setId(idCategory);
            product.setCategory(category);
            try{
                productRespository.save(product);
            }catch(Exception e){
                System.out.println("lỗi insert product " + e.getLocalizedMessage());
            }

        return true;
    }

    @Override
    public Resource downloadProductFile(String tenFile) {

        return fileStorageServiceImp.loadFile(tenFile);
    }
}
