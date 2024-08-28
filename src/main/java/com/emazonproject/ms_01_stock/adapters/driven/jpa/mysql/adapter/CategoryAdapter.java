package com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.adapter;

import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazonproject.ms_01_stock.dominio.model.Category;
import com.emazonproject.ms_01_stock.dominio.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new CategoryAlreadyExistsException();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public Category getOneCategory(String name) {
        CategoryEntity category= categoryRepository.findByNameContaining(name).
                orElseThrow(ElementNotFoundException::new);
        return categoryEntityMapper.toModel(category);
    }

    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(pageable);
        return categoryEntities.map(categoryEntityMapper::toModel);
    }


    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

}
