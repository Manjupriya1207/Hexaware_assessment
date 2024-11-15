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

import com.springboot.usedcarseller.model.DoorstepInspection;
import com.springboot.usedcarseller.service.DoorstepInspectionService;

@RestController
@RequestMapping("/api/inspections")
public class DoorstepInspectionController {

    @Autowired
    private DoorstepInspectionService inspectionService;

    @GetMapping
    public List<DoorstepInspection> getAllInspections() {
        return inspectionService.getAllInspections();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoorstepInspection> getInspectionById(@PathVariable int id) {
        Optional<DoorstepInspection> inspection = inspectionService.getInspectionById(id);
        return inspection.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DoorstepInspection> createInspection(@RequestBody DoorstepInspection inspection) {
        DoorstepInspection createdInspection = inspectionService.createInspection(inspection);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInspection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoorstepInspection> updateInspection(@PathVariable int id,
                                                                @RequestBody DoorstepInspection inspectionDetails) {
        DoorstepInspection updatedInspection = inspectionService.updateInspection(id, inspectionDetails);
        return ResponseEntity.ok(updatedInspection);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInspection(@PathVariable int id) {
        inspectionService.deleteInspection(id);
        return ResponseEntity.noContent().build();
    }
}