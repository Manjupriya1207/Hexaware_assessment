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

import com.springboot.usedcarseller.model.Pickup;
import com.springboot.usedcarseller.service.PickupService;

@RestController
@RequestMapping("/api/pickups")
public class PickupController {
    @Autowired
    private PickupService pickupService;

    @PostMapping("/{paymentId}")
    public ResponseEntity<Pickup> createPickup(@PathVariable int paymentId, @RequestBody Pickup pickup) {
        Pickup createdPickup = pickupService.createPickup(paymentId, pickup);
        return ResponseEntity.ok(createdPickup);
    }

    @GetMapping
    public List<Pickup> getAllPickups() {
        return pickupService.getAllPickups();
    }

    @GetMapping("/{pickupId}")
    public ResponseEntity<Pickup> getPickupById(@PathVariable int pickupId) {
        Pickup pickup = pickupService.getPickupById(pickupId);
        return ResponseEntity.ok(pickup);
    }

    @PutMapping("/{pickupId}")
    public ResponseEntity<Pickup> updatePickup(@PathVariable int pickupId, @RequestBody Pickup pickupDetails) {
        Pickup updatedPickup = pickupService.updatePickup(pickupId, pickupDetails);
        return ResponseEntity.ok(updatedPickup);
    }

    @DeleteMapping("/{pickupId}")
    public ResponseEntity<Void> deletePickup(@PathVariable int pickupId) {
        pickupService.deletePickup(pickupId);
        return ResponseEntity.noContent().build();
    }
}
