package com.springboot.usedcarseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.usedcarseller.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
}