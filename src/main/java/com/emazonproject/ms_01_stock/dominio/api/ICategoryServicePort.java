package com.emazonproject.ms_01_stock.dominio.api;

import com.emazonproject.ms_01_stock.dominio.model.Category;

import java.util.List;

public interface ICategoryServicePort {

    void saveCategory(Category category);
    Category getOneCategory (String name);
    List<Category> getAllCategory(Integer page, Integer size);



}
