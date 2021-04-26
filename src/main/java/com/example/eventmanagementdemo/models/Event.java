package com.example.eventmanagementdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private Long eventId;
    private String name;
    private String description;
    private String address;
    private Date date;
    private String organizer;

   @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToMany(mappedBy = "events")
    @JsonIgnore
    private List<Participant> participants;


    public Event() {
    }

    public Event(String name, String address, Date date, String organizer, Category category) {
        this.name = name;
        this.address = address;
        this.date = date;
        this.organizer = organizer;
        this.category = category;
    }

    public Event(String name, String description, String address, Date date, String organizer, Category category) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.date = date;
        this.organizer = organizer;
        this.category = category;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
