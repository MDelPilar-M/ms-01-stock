package com.EmazonProject.ms_01_stock.adapter.driving.http.controller;

import com.EmazonProject.ms_01_stock.adapter.driving.http.dto.request.CategoryRequest;
import com.EmazonProject.ms_01_stock.adapter.driving.http.dto.response.CategoryResponse;
import com.EmazonProject.ms_01_stock.adapter.mapper.iCategoryRequestMapper;
import com.EmazonProject.ms_01_stock.adapter.mapper.iCategoryResponseMapper;
import com.EmazonProject.ms_01_stock.dominio.api.iCategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryRestController {
    private final iCategoryServicePort categoryServicePort;
    private final iCategoryRequestMapper categoryRequestMapper;
    private final iCategoryResponseMapper categoryResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addCategory(@RequestBody CategoryRequest request) {
        categoryServicePort.saveCategory(categoryRequestMapper.toCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryResponse>> getAllCategory(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(categoryResponseMapper.toResponseList(categoryServicePort.getAllCategory(page, size)));
    }



}
