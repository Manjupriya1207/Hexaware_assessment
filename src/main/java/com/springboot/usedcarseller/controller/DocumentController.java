package com.springboot.usedcarseller.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.usedcarseller.model.Document;
import com.springboot.usedcarseller.service.DocumentService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable int id) {
        Optional<Document> document = documentService.getDocumentById(id);
        return document.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{inspectionId}")  // Endpoint to create a document for a specific inspection
    public ResponseEntity<Document> createDocument(@PathVariable int inspectionId,
                                                   @RequestBody Document document) {
        Document createdDocument = documentService.createDocument(inspectionId, document);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable int id,
                                                   @RequestBody Document documentDetails) {
        Document updatedDocument = documentService.updateDocument(id, documentDetails);
        return ResponseEntity.ok(updatedDocument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable int id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/inspection /{inspectionId}")  // Endpoint to get documents by inspection ID
    public ResponseEntity<List<Document>> getDocumentsByInspectionId(@PathVariable int inspectionId) {
        List<Document> documents = documentService.getDocumentsByInspectionId(inspectionId);
        return ResponseEntity.ok(documents);
    }
}