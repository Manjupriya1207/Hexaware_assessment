package com.springboot.usedcarseller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.usedcarseller.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    List<Document> findByInspection_InspectionId(int inspectionId); 
}