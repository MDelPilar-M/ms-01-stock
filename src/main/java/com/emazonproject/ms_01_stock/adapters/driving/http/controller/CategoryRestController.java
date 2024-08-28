package com.emazonproject.ms_01_stock.adapters.driving.http.controller;

import com.emazonproject.ms_01_stock.adapters.driving.http.dto.request.CategoryRequest;
import com.emazonproject.ms_01_stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazonproject.ms_01_stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazonproject.ms_01_stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazonproject.ms_01_stock.dominio.api.ICategoryServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<CategoryResponse>> getAllCategory(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(categoryResponseMapper.toResponseList(categoryServicePort.getAllCategory(pageNumber, pageSize)));
    }



}
