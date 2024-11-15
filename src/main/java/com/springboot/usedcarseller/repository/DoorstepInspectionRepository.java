package com.springboot.usedcarseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.usedcarseller.model.DoorstepInspection;

@Repository
public interface DoorstepInspectionRepository extends JpaRepository<DoorstepInspection, Integer> {
  
}