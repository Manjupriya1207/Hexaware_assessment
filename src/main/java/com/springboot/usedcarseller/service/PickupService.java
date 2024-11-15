package com.springboot.usedcarseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.usedcarseller.model.Payment;
import com.springboot.usedcarseller.model.Pickup;
import com.springboot.usedcarseller.repository.PaymentRepository;
import com.springboot.usedcarseller.repository.PickupRepository;



@Service
public class PickupService {
    @Autowired
    private PickupRepository pickupRepository;

    @Autowired
    private PaymentRepository paymentRepository; 

    @Transactional
    public Pickup createPickup(int paymentId, Pickup pickup) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + paymentId));
        pickup.setPayment(payment); // Set the payment reference
        return pickupRepository.save(pickup);
    }

    @Transactional(readOnly = true)
    public List<Pickup> getAllPickups() {
        return pickupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Pickup getPickupById(int pickupId) {
        return pickupRepository.findById(pickupId)
                .orElseThrow(() -> new RuntimeException("Pickup not found with id " + pickupId));
    }

    @Transactional
    public Pickup updatePickup(int pickupId, Pickup pickupDetails) {
        Pickup pickup = getPickupById(pickupId);
        pickup.setPickupStatus(pickupDetails.getPickupStatus());
        pickup.setPickupScheduledAt(pickupDetails.getPickupScheduledAt());

        // Optionally update the associated payment if needed
        if (pickupDetails.getPayment() != null) {
            Payment payment = paymentRepository.findById(pickupDetails.getPayment().getPaymentId())
                    .orElseThrow(() -> new RuntimeException("Payment not found with id " + pickupDetails.getPayment().getPaymentId()));
            pickup.setPayment(payment);
        }

        return pickupRepository.save(pickup);
    }

    @Transactional
    public void deletePickup(int pickupId) {
        Pickup pickup = getPickupById(pickupId);
        pickupRepository.delete(pickup);
    }
}