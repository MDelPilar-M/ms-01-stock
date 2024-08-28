package com.emazonproject.ms_01_stock.dominio.spi;

import com.emazonproject.ms_01_stock.dominio.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {

    void saveCategory(Category category);
    Category getOneCategory (String name);
    List<Category> getAllCategory(Integer page, Integer size);
    boolean existsByName(String name);

}
