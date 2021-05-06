package com.example.eventmanagementdemo.services;
import com.example.eventmanagementdemo.dtos.CategoryDto;
import com.example.eventmanagementdemo.dtos.EventCreateDto;
import com.example.eventmanagementdemo.dtos.EventDto;
import com.example.eventmanagementdemo.mappers.CategoryMapper;
import com.example.eventmanagementdemo.mappers.EventCreateMapper;
import com.example.eventmanagementdemo.mappers.EventMapper;
import com.example.eventmanagementdemo.models.Category;
import com.example.eventmanagementdemo.models.Event;
import com.example.eventmanagementdemo.repositories.IEventRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EventService implements  IEventService{
    @Autowired
    private IEventRepository eventRepository;

    @Override
    public List<EventDto> getAll() {
        List<Event> events = eventRepository.findAll();
        List<EventDto> eventsDto = new ArrayList<>();

        for( Event event :events)
            eventsDto.add(EventMapper.INSTANCE.EventToEventDto(event));

        return eventsDto;
    }

   public Event get(Long id){
        return eventRepository.findById(id).get();
    }


    public Event create(EventCreateDto event){
        return eventRepository.saveAndFlush(EventCreateMapper.INSTANCE.EventDtoToEvent(event));
    }

    public void delete( Long id){
        //Also need to check for children records before deleting
        eventRepository.deleteById(id);
    }

    public Event update(Long id, Event Event){
        Event existingEvent = eventRepository.findById(id).get();
        BeanUtils.copyProperties(Event, existingEvent, "Event_id");
        return eventRepository.saveAndFlush(Event);
    }
}
