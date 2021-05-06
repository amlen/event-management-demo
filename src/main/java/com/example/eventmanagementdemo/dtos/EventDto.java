package com.example.eventmanagementdemo.dtos;

import com.example.eventmanagementdemo.models.Participant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



public class EventDto {

    private Long id;
    private String name;
    private String description;
    private String address;
    private Date date;
    private String organizer;
    private String categoryName;

    public EventDto() {
    }

    public EventDto(String name, String description, String address, Date date, String organizer, String categoryName) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.date = date;
        this.organizer = organizer;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
