package com.springboot.usedcarseller.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.usedcarseller.model.Document;
import com.springboot.usedcarseller.model.Payment;
import com.springboot.usedcarseller.repository.DocumentRepository;
import com.springboot.usedcarseller.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private DocumentRepository documentRepository; // To fetch Document

    public Payment createPayment(int documentId, Payment payment) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found with id " + documentId));
        payment.setDocument(document); // Set the document reference
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + paymentId));
    }


    public void deletePayment(int paymentId) {
        Payment payment = getPaymentById(paymentId);
        paymentRepository.delete(payment);
    }
}