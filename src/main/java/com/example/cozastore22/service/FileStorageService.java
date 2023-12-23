package com.example.cozastore22.service;

import com.example.cozastore22.service.imp.FileStorageServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService implements FileStorageServiceImp {

    @Value("${path.upload.file}")
    private String folderRoot;
    Path root;
    @Override
    public boolean saveFile(MultipartFile file) {
        boolean isSuccess = false;
        try{
            root = Paths.get(folderRoot);
            if(!Files.exists(root))
            {
                Files.createDirectories(root);
            }
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            isSuccess = true;
            System.out.println("Kiemtra upload" + isSuccess);
            System.out.println("Kiemtra upload" + folderRoot);
        }catch(Exception e){
            System.out.println("Lỗi" + e.getLocalizedMessage());
        }

        return isSuccess;
    }

    @Override
    public Resource loadFile(String fileName) {
        try{
            root = Paths.get(folderRoot);
            Path pathFile = root.resolve(fileName);
            Resource resource = new UrlResource(pathFile.toUri());
            if(resource.exists())
            {
                return resource;
            }
        }catch(Exception e){
            System.out.println("Lỗi load file " + e.getLocalizedMessage());
        }

        return null;
    }
}
