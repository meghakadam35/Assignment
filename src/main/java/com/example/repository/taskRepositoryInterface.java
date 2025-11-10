package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.entity.Task;

public interface taskRepositoryInterface extends JpaRepository<Task, Long>{

}
