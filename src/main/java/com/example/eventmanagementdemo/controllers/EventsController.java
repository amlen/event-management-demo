package com.example.eventmanagementdemo.controllers;
import com.example.eventmanagementdemo.models.Event;
import com.example.eventmanagementdemo.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {
    @Autowired
    private IEventService eventService;

    @GetMapping
    public List<Event> list(){
        return eventService.getAll();
    }

   @GetMapping
    @RequestMapping("{id}")
    public Event get(@PathVariable Long id){
        return eventService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@RequestBody Event event){
        return eventService.create(event);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //Also need to check for children records before deleting
        eventService.delete(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public Event update(@PathVariable Long id, @RequestBody Event Event){
        return eventService.update(id,Event);
    }
}
