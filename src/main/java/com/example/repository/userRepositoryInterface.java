package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.entity.User;

public interface userRepositoryInterface extends JpaRepository<User, Long> {
	
}
