package com.example.cozastore22.repository;

import com.example.cozastore22.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<ProductEntity, Integer> {
}
