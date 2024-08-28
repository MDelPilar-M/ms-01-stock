package com.emazonproject.ms_01_stock.adapters.driving.http.mapper;

import com.emazonproject.ms_01_stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazonproject.ms_01_stock.dominio.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ICategoryResponseMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    CategoryResponse toResponse(Category category);
    default Page<CategoryResponse> toResponsePage(Page<Category> categoriesPage) {
        List<CategoryResponse> categoryResponses = categoriesPage.getContent()
                .stream()
                .map(this::toResponse)
                .toList();

        return new PageImpl<>(categoryResponses, categoriesPage.getPageable(), categoriesPage.getTotalElements());
    }

}
