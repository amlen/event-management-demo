package com.example.eventmanagementdemo.converters;

import com.example.eventmanagementdemo.dtos.CategoryDto;
import com.example.eventmanagementdemo.dtos.EventDto;
import com.example.eventmanagementdemo.models.Category;
import com.example.eventmanagementdemo.models.Event;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapperConverter implements Converter {
    private ModelMapper modelMapper;

    public ModelMapperConverter() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Category convert(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    @Override
    public CategoryDto convert(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public EventDto convert(Event event) {
        modelMapper.addMappings(new PropertyMap<Event, EventDto>() {
            @Override
            protected void configure() {
                map().setCategoryId(source.getCategory().getId());
            }
        });
        return modelMapper.map(event, EventDto.class);
    }

    @Override
    public Event convert(EventDto eventDto) {
        return modelMapper.map(eventDto, Event.class);
    }

    @Override
    public List<CategoryDto> convert(List<Category> categoryList, Class<CategoryDto> categoryDtoClass) {


        List<CategoryDto> dtos = categoryList
                .stream()
                .map(user -> modelMapper.map(user, categoryDtoClass))
                .collect(Collectors.toList());
        return dtos;
    }
}