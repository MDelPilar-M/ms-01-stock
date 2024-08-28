package com.EmazonProject.ms_01_stock.adapters.mapper;

import com.EmazonProject.ms_01_stock.adapters.driving.http.dto.response.CategoryResponse;
import com.EmazonProject.ms_01_stock.dominio.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface iCategoryResponseMapper {
    //convertir de category a response
    @Mapping(target = "idCtg", ignore = true)
    @Mapping(target = "nameCtg")
    @Mapping(target = "descriptionCtg")
    CategoryResponse toResponse(Category category);

    default List<CategoryResponse> toResponseList(List<Category> categoryList){
        return categoryList.stream()
                .map(category -> {
                    CategoryResponse categoryResponse = new CategoryResponse();
                    categoryResponse.setNameCtg(category.getNameCtg());
                    categoryResponse.setDescriptionCtg((category.getDescriptionCtg()));
                    return categoryResponse;

        }).toList();
    }

}
