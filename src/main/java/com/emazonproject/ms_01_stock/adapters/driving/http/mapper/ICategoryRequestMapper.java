package com.EmazonProject.ms_01_stock.adapters.mapper;

import com.EmazonProject.ms_01_stock.adapters.driving.http.dto.request.CategoryRequest;
import com.EmazonProject.ms_01_stock.dominio.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface iCategoryRequestMapper {
    // convertir de CategoryRequest a Category

    @Mapping(target = "idCtg", ignore = true)
    @Mapping(target = "nameCtg")
    @Mapping(target = "descriptionCtg")
    Category toCategory(CategoryRequest categoryRequest);

}
