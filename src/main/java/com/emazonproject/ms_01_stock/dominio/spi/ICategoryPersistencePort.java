package com.emazonproject.ms_01_stock.dominio.spi;

import com.emazonproject.ms_01_stock.dominio.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryPersistencePort {

    void saveCategory(Category category);
    Category getOneCategory (String name);
    Page<Category> getAllCategory(Pageable pageable);
    boolean existsByName(String name);

}
