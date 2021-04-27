package com.example.eventmanagementdemo.repositories;

import com.example.eventmanagementdemo.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParticipantRepository extends JpaRepository<Participant,Long> {
}
