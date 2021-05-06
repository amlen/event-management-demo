package com.example.eventmanagementdemo.services;


import com.example.eventmanagementdemo.dtos.*;
import com.example.eventmanagementdemo.models.Event;

import java.util.List;

public interface IEventService {
    public List<EventDto> getAll();
    public Event get(Long id);
    public Event create(EventCreateDto Event);
    public void delete( Long id);
    public Event update(Long id, Event Event);
}
