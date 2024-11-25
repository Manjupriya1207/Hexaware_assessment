package com.springboot.usedcarseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.usedcarseller.model.Pickup;

@Repository
public interface PickupRepository extends JpaRepository<Pickup, Integer> {
    
}