package com.example.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.entity.ProjectManagement;

public interface projectRepositoryInterface extends JpaRepository<ProjectManagement, Long>{

}
