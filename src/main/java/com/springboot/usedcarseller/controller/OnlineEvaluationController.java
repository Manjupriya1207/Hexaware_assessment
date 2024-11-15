package com.springboot.usedcarseller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.usedcarseller.model.OnlineEvaluation;
import com.springboot.usedcarseller.service.OnlineEvaluationService;

@RestController
@RequestMapping("/api/evaluations")
public class OnlineEvaluationController {

    @Autowired
    private OnlineEvaluationService onlineEvaluationService;

    @GetMapping
    public List<OnlineEvaluation> getAllEvaluations() {
        return onlineEvaluationService.getAllEvaluations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OnlineEvaluation> getEvaluationById(@PathVariable int id) {
        return onlineEvaluationService.getEvaluationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OnlineEvaluation createEvaluation(@RequestBody OnlineEvaluation evaluation) {
        return onlineEvaluationService.createEvaluation(evaluation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OnlineEvaluation> updateEvaluation(@PathVariable int id, @RequestBody OnlineEvaluation evaluationDetails) {
        OnlineEvaluation updatedEvaluation = onlineEvaluationService.updateEvaluation(id, evaluationDetails);
        return ResponseEntity.ok(updatedEvaluation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable int id) {
        onlineEvaluationService.deleteEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
