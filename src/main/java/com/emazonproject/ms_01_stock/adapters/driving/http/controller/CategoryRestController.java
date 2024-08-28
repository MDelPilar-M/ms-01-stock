package com.emazonproject.ms_01_stock.adapters.driving.http.controller;

import com.emazonproject.ms_01_stock.adapters.driving.http.dto.request.CategoryRequest;
import com.emazonproject.ms_01_stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazonproject.ms_01_stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazonproject.ms_01_stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazonproject.ms_01_stock.dominio.api.ICategoryServicePort;
import com.emazonproject.ms_01_stock.dominio.model.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CategoryRestController {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;

    @PostMapping("/categories")
    public ResponseEntity<Void> saveCategory(@RequestBody @Valid CategoryRequest request) {
        categoryServicePort.saveCategory(categoryRequestMapper.toCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/categories")
    public Page<CategoryResponse> getAllCategories(
            @RequestParam(required = false, defaultValue = "name") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Sort sort = Sort.by(sortOrder.equalsIgnoreCase("desc") ? Sort.Order.desc(sortBy) : Sort.Order.asc(sortBy));
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Category> categoryPage = categoryServicePort.getAllCategory(pageable);
        return categoryResponseMapper.toResponsePage(categoryPage);

    }
}
