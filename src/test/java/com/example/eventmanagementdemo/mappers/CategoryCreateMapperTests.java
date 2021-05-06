package com.example.eventmanagementdemo.mappers;

import com.example.eventmanagementdemo.dtos.CategoryCreateDto;
import com.example.eventmanagementdemo.models.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryCreateMapperTests {

    @Test
    public void shouldMapCategoryCreateDtoToCategory() {
        //given
        CategoryCreateDto categoryCreateDto = new CategoryCreateDto("It spring", "It event ....");

        //when
        Category category = CategoryCreateMapper.INSTANCE.CategoryCreateDtoToCategory(categoryCreateDto);

        //then
        assertNotEquals( null, categoryCreateDto );
        assertEquals("It spring", category.getName());
        assertEquals("It event ....", category.getDescription());
    }
}
