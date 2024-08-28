package com.EmazonProject.ms_01_stock.spi;

import com.EmazonProject.ms_01_stock.dominio.model.Category;

import java.util.List;

public interface iCategoryPersistencePort {

    void saveCategory(Category category);
    List<Category> getAllCategory();
    Category getCategory(String nameCtg);
}
