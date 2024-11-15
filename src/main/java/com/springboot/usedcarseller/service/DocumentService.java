package com.springboot.usedcarseller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.usedcarseller.model.Document;
import com.springboot.usedcarseller.model.DoorstepInspection;
import com.springboot.usedcarseller.repository.DocumentRepository;
import com.springboot.usedcarseller.repository.DoorstepInspectionRepository;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DoorstepInspectionRepository inspectionRepository; // Add this for inspection lookup

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Optional<Document> getDocumentById(int id) {
        return documentRepository.findById(id);
    }

    public Document createDocument(int inspectionId, Document document) {
        DoorstepInspection inspection = inspectionRepository.findById(inspectionId)
                .orElseThrow(() -> new RuntimeException("Inspection not found with id " + inspectionId));
        
        document.setInspection(inspection);  // Set the inspection for the document
        return documentRepository.save(document);
    }

    public Document updateDocument(int id, Document documentDetails) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found with id " + id));
        
        document.setDocumentUpload(documentDetails.isDocumentUpload());
        document.setDocumentUploadedAt(documentDetails.getDocumentUploadedAt());
        document.setDocumentVerified(documentDetails.isDocumentVerified());
        document.setDocumentVerifiedAt(documentDetails.getDocumentVerifiedAt());
        document.setDocumentType(documentDetails.getDocumentType());
        document.setPicturePath(documentDetails.getPicturePath());
        
        return documentRepository.save(document);
    }

    public void deleteDocument(int id) {
        documentRepository.deleteById(id);
    }

    public List<Document> getDocumentsByInspectionId(int inspectionId) {
        return documentRepository.findByInspection_InspectionId(inspectionId);
    }
}