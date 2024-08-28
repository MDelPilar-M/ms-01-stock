package com.emazonproject.ms_01_stock.adapters.driving.http.mapper;

import com.emazonproject.ms_01_stock.adapters.driving.http.dto.request.CategoryRequest;
import com.emazonproject.ms_01_stock.dominio.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ICategoryRequestMapper {
    // convertir de CategoryRequest a Category

    @Mapping(target = "id", ignore = true)
    Category toCategory(CategoryRequest categoryRequest);

}
