package com.example.eventmanagementdemo.services;
import com.example.eventmanagementdemo.models.Event;
import com.example.eventmanagementdemo.repositories.IEventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EventService implements  IEventService{
    @Autowired
    private IEventRepository eventRepository;

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

   public Event get(Long id){
        return eventRepository.findById(id).get();
    }


    public Event create(Event Event){
        return eventRepository.saveAndFlush(Event);
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
