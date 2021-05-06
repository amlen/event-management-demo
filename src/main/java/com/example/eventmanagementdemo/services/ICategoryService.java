package com.example.eventmanagementdemo.services;
import com.example.eventmanagementdemo.dtos.CategoryCreateDto;
import com.example.eventmanagementdemo.dtos.CategoryDto;
import com.example.eventmanagementdemo.exceptions.ResourceNotFoundException;
import com.example.eventmanagementdemo.models.Category;

import java.util.List;

public interface ICategoryService {
    public List<CategoryDto> getAll();
    public Category get(Long id) throws ResourceNotFoundException;
    public Category create(CategoryCreateDto category);
    public void delete( Long id);
    public Category update(Long id, Category category);
}
