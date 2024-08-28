package com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.mapper;

import com.emazonproject.ms_01_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazonproject.ms_01_stock.dominio.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryEntityMapper {

    @Mapping(target = "id")
    @Mapping(target = "name")
    @Mapping(target = "description")
    Category toModel(CategoryEntity categoryEntity);
    @Mapping(target = "id")
    @Mapping(target = "name")
    @Mapping(target = "description")
    CategoryEntity toEntity(Category category);
    List<Category> toModelList(List<CategoryEntity> categories);

}
