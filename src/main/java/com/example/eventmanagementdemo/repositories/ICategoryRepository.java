package com.example.eventmanagementdemo.repositories;


import com.example.eventmanagementdemo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
