package com.example.cozastore22.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface ProducServiceImp {
    boolean insertProduct(String title, double prices, int idCategory);
    Resource downloadProductFile(String tenFile);

}
