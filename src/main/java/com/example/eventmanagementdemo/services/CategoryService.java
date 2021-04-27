package com.example.eventmanagementdemo.services;
import com.example.eventmanagementdemo.models.Category;
import com.example.eventmanagementdemo.repositories.ICategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService implements  ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;


    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category get(Long id){
        return categoryRepository.findById(id).get();
    }


    public Category create(Category category){
        return categoryRepository.saveAndFlush(category);
    }

    public void delete( Long id){
        //Also need to check for children records before deleting
        categoryRepository.deleteById(id);
    }

    public Category update(Long id, Category Category){
        Category existingCategory = categoryRepository.findById(id).get();
        BeanUtils.copyProperties(Category, existingCategory, "Category_id");
        return categoryRepository.saveAndFlush(Category);
    }
}
