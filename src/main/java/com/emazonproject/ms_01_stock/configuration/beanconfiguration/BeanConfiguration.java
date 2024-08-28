package com.emazonproject.ms_01_stock.configuration.beanconfiguration;

import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.adapter.CategoryAdapter;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazonproject.ms_01_stock.dominio.api.ICategoryServicePort;
import com.emazonproject.ms_01_stock.dominio.api.usecase.CategoryUseCase;
import com.emazonproject.ms_01_stock.dominio.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }
    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }

}
