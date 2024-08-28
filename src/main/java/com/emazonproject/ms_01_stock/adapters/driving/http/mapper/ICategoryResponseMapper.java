package com.emazonproject.ms_01_stock.adapters.driving.http.mapper;

import com.emazonproject.ms_01_stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazonproject.ms_01_stock.dominio.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ICategoryResponseMapper {
    //convertir de category a response

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    CategoryResponse toResponse(Category category);
    default List<CategoryResponse> toResponseList(List<Category> categories) {
        return categories.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
