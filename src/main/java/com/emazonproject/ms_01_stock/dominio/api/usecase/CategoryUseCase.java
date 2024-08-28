package com.EmazonProject.ms_01_stock.dominio.usecase;

import com.EmazonProject.ms_01_stock.dominio.api.iCategoryServicePort;
import com.EmazonProject.ms_01_stock.dominio.model.Category;
import com.EmazonProject.ms_01_stock.dominio.spi.iCategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements iCategoryServicePort {

    private final iCategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(iCategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategory(Integer page, Integer size) {
        return categoryPersistencePort.getAllCategory(page, size);
    }


}
