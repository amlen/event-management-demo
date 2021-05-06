package com.example.eventmanagementdemo.mappers;

import com.example.eventmanagementdemo.dtos.EventDto;
import com.example.eventmanagementdemo.models.Category;
import com.example.eventmanagementdemo.models.Event;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EventMapperTests {

    @Test
    public void shouldMapEventToEventDto() {
        //given
        Category category =  new Category("IT", "software engineering");
        Event event = new Event("DevOps", "23 center Brussels", null, "XYZ", category);

        //when
        EventDto eventDto = EventMapper.INSTANCE.EventToEventDto(event);

        //then
        assertNotEquals( null, eventDto );
        assertEquals("DevOps", eventDto.getName());
        assertEquals("23 center Brussels", eventDto.getAddress());
        assertEquals(null, eventDto.getDate());
        assertEquals("XYZ", eventDto.getOrganizer());
        assertEquals("IT", eventDto.getCategoryName());
    }

    @Test
    public void shouldGetCategoryName(){
        //given
        Category category =  new Category("IT", "software engineering");
        Event event = new Event("DevOps", "23 center Brussels", null, "XYZ", category);

        //when
        String categoryName = EventMapper.INSTANCE.getCategoryName(event);

        //then
        assertEquals("IT", categoryName);
    }


}
