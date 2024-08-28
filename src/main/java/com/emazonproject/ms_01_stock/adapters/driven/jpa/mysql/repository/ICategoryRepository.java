package com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.repository;

import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository <CategoryEntity, Long> , PagingAndSortingRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByNameContaining(String name);
    Optional<CategoryEntity> findByName(String name);
    boolean existsByName(String name);

}
