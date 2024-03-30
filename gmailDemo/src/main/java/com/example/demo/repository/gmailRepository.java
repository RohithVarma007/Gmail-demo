package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.starterClass;

public interface gmailRepository extends JpaRepository<starterClass, Integer> {
    
}

