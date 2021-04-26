package com.example.eventmanagementdemo.repositories;

import com.example.eventmanagementdemo.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
