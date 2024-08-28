package com.emazonproject.ms_01_stock.dominio.api.usecase;

import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.emazonproject.ms_01_stock.dominio.api.ICategoryServicePort;
import com.emazonproject.ms_01_stock.dominio.exception.EmptyFieldException;
import com.emazonproject.ms_01_stock.dominio.model.Category;
import com.emazonproject.ms_01_stock.dominio.spi.ICategoryPersistencePort;
import com.emazonproject.ms_01_stock.dominio.util.DomainConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        validateCategory(category);
        if (categoryPersistencePort.existsByName(category.getName())) {
            throw new CategoryAlreadyExistsException();
        }
        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public Category getOneCategory(String name) {return categoryPersistencePort.getOneCategory(name);}

    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        return categoryPersistencePort.getAllCategory(pageable);
    }

    private void validateCategory(Category category) {

        if (category.getName() == null || category.getName().trim().isEmpty()) {throw new EmptyFieldException(DomainConstants.Field.NAME.toString());}
        if (category.getName().length() > DomainConstants.DATA_SIZE_LIMIT_NAME) {throw new IllegalArgumentException(DomainConstants.DATA_SIZE_LIMIT_NAME_MESSAGE);}
        if (category.getDescription() == null || category.getDescription().trim().isEmpty()) {throw new EmptyFieldException(DomainConstants.Field.DESCRIPTION.toString());}
        if (category.getDescription().length() > DomainConstants.DATA_SIZE_LIMIT_DESCRIPTION) {throw new IllegalArgumentException(DomainConstants.DATA_SIZE_LIMIT_DESCRIPTION_MESSAGE);}
    }
}
