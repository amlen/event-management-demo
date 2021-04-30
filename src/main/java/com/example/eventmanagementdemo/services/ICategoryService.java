package com.example.eventmanagementdemo.services;
import com.example.eventmanagementdemo.exceptions.ResourceNotFoundException;
import com.example.eventmanagementdemo.models.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> getAll();
    public Category get(Long id) throws ResourceNotFoundException;
    public Category create(Category category);
    public void delete( Long id);
    public Category update(Long id, Category category);
}
