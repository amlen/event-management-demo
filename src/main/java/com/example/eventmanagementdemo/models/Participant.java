package com.example.eventmanagementdemo.models;

import javax.persistence.*;
import java.util.List;

@Entity(name="participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "participant_id")
    private Long participantId;
    private String first_name;
    private String last_name;
    private String email;
    private Character gender;

    @ManyToMany
    @JoinTable(
            name = "participants_events",
            joinColumns=@JoinColumn(name ="participant_id"),
            inverseJoinColumns = @JoinColumn(name ="event_id"))
    private List<Event> events;

    public Participant() {
    }

    public Participant(String first_name, String last_name, String email, Character gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
