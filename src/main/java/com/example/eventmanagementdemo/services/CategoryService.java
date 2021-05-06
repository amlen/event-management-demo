package com.example.eventmanagementdemo.services;
import com.example.eventmanagementdemo.dtos.CategoryCreateDto;
import com.example.eventmanagementdemo.dtos.CategoryDto;
import com.example.eventmanagementdemo.mappers.CategoryCreateMapper;
import com.example.eventmanagementdemo.mappers.CategoryMapper;
import com.example.eventmanagementdemo.models.Category;
import com.example.eventmanagementdemo.repositories.ICategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements  ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;


    public List<CategoryDto> getAll(){

        List<Category> categories =  categoryRepository.findAll();

        List<CategoryDto> categoriesDto = new ArrayList<>();

        for( Category category :categories)
            categoriesDto.add(CategoryMapper.INSTANCE.CategoryToCategoryDto(category));

        return categoriesDto;
    }

    public Category get(Long id){
        return  categoryRepository.findById(id).orElse(null);
    }


    public Category create(CategoryCreateDto categoryCreateDto){
        Category category = CategoryCreateMapper.INSTANCE.CategoryCreateDtoToCategory(categoryCreateDto);
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
