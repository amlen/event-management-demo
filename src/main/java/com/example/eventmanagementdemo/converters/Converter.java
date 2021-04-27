package com.example.eventmanagementdemo.converters;

import com.example.eventmanagementdemo.dtos.CategoryDto;
import com.example.eventmanagementdemo.dtos.EventDto;
import com.example.eventmanagementdemo.models.Category;
import com.example.eventmanagementdemo.models.Event;

import java.util.List;

public interface Converter {
    Category convert(CategoryDto categoryDto);
    CategoryDto convert(Category category);

    Event convert(EventDto eventDto);
    EventDto convert(Event event);

    List<CategoryDto> convert(List<Category> categoryList, Class<CategoryDto> categoryDtoClass);

}
