package com.emazonproject.ms_01_stock.dominio.api;

import com.emazonproject.ms_01_stock.dominio.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryServicePort {

    void saveCategory(Category category);
    Category getOneCategory (String name);
    Page<Category> getAllCategory(Pageable pageable);



}
