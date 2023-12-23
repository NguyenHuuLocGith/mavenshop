package com.example.cozastore22.service;

import com.example.cozastore22.entity.CategoryEntity;
import com.example.cozastore22.payload.response.CategoryResponse;
import com.example.cozastore22.repository.CategoryRepository;
import com.example.cozastore22.service.imp.CategoryServiceImp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.hibernate.annotations.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    private CategoryRepository categoryRepository;
   // @Cacheable("allCategory")

    @Autowired
    private RedisTemplate redisTemplate;
    private Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private Gson gson = new Gson();
    @Override
    public List<CategoryResponse> getAllCategory() {

        List<CategoryResponse> listResponse = new ArrayList<>();
        if(redisTemplate.hasKey("listCategory") != null){
            logger.info("kiem tra cache redis");
            String dataRedis = redisTemplate.opsForValue().get("listCategory").toString();
            Type listType = new TypeToken<ArrayList<CategoryResponse>>(){}.getType();
            listResponse = gson.fromJson(dataRedis,listType);
        }else {
            logger.info("kiemtra category database no cache");
            List<CategoryEntity> list = categoryRepository.findAll();

            for (CategoryEntity item : list) {
                CategoryResponse categoryResponse = new CategoryResponse();
                categoryResponse.setId(item.getId());
                categoryResponse.setName(item.getName());
                listResponse.add(categoryResponse);
            }
        }

        //
        String dataJson = gson.toJson(listResponse);
        redisTemplate.opsForValue().set("listCategory", dataJson);
        return listResponse;
    }
}
