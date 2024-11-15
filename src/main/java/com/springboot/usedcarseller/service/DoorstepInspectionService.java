package com.springboot.usedcarseller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.usedcarseller.model.DoorstepInspection;
import com.springboot.usedcarseller.repository.DoorstepInspectionRepository;

@Service
public class DoorstepInspectionService {

    @Autowired
    private DoorstepInspectionRepository inspectionRepository;

    public List<DoorstepInspection> getAllInspections() {
        return inspectionRepository.findAll();
    }

    public Optional<DoorstepInspection> getInspectionById(int id) {
        return inspectionRepository.findById(id);
    }

    public DoorstepInspection createInspection(DoorstepInspection inspection) {
        return inspectionRepository.save(inspection);
    }

    public DoorstepInspection updateInspection(int id, DoorstepInspection inspectionDetails) {
        DoorstepInspection inspection = inspectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inspection not found with id " + id));
        
        inspection.setSeller(inspectionDetails.getSeller());
        inspection.setPhoneNumber(inspectionDetails.getPhoneNumber());
        inspection.setAddress(inspectionDetails.getAddress());
        inspection.setScheduledDate(inspectionDetails.getScheduledDate());
        inspection.setInspectionStatus(inspectionDetails.getInspectionStatus());
        inspection.setInspectionVerified(inspectionDetails.isInspectionVerified());
        
        return inspectionRepository.save(inspection);
    }

    public void deleteInspection(int id) {
        inspectionRepository.deleteById(id);
    }
}