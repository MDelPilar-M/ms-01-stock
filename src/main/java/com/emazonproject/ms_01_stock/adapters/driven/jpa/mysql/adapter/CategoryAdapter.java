package com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.adapter;

import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazonproject.ms_01_stock.dominio.model.Category;
import com.emazonproject.ms_01_stock.dominio.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

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
    public List<Category> getAllCategory(Integer pageNumber, Integer pageSize) {
          Pageable pagination = PageRequest.of(pageNumber, pageSize);
          List<CategoryEntity> categories=categoryRepository.findAll(pagination).getContent();
          if (categories.isEmpty()){
              throw new NoDataFoundException();
          }
          return categoryEntityMapper.toModelList(categories);

    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

}
