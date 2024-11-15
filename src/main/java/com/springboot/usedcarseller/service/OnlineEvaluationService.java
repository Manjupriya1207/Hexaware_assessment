package com.springboot.usedcarseller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.usedcarseller.model.OnlineEvaluation;
import com.springboot.usedcarseller.repository.OnlineEvaluationRepository;

@Service
public class OnlineEvaluationService {

    @Autowired
    private OnlineEvaluationRepository onlineEvaluationRepository;

    public List<OnlineEvaluation> getAllEvaluations() {
        return onlineEvaluationRepository.findAll();
    }

    public Optional<OnlineEvaluation> getEvaluationById(int id) {
        return onlineEvaluationRepository.findById(id);
    }

    public OnlineEvaluation createEvaluation(OnlineEvaluation evaluation) {
        return onlineEvaluationRepository.save(evaluation);
    }

    public OnlineEvaluation updateEvaluation(int id, OnlineEvaluation evaluationDetails) {
        OnlineEvaluation evaluation = onlineEvaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found with id " + id));
        evaluation.setBrand(evaluationDetails.getBrand());
        evaluation.setRtoLocation(evaluationDetails.getRtoLocation());
        evaluation.setManufacturingYear(evaluationDetails.getManufacturingYear());
        evaluation.setModel(evaluationDetails.getModel());
        evaluation.setVariant(evaluationDetails.getVariant());
        evaluation.setKmDriven(evaluationDetails.getKmDriven());
        evaluation.setCarOwnership(evaluationDetails.getCarOwnership());
        evaluation.setUserLocation(evaluationDetails.getUserLocation());
        return onlineEvaluationRepository.save(evaluation);
    }

    public void deleteEvaluation(int id) {
        OnlineEvaluation evaluation = onlineEvaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found with id " + id));
        onlineEvaluationRepository.delete(evaluation);
    }
}