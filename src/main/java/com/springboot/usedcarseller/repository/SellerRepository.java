package com.springboot.usedcarseller.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.usedcarseller.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
