package com.springboot.usedcarseller.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.usedcarseller.exception.ResourceNotFoundException;
import com.springboot.usedcarseller.model.Seller;
import com.springboot.usedcarseller.model.User;
import com.springboot.usedcarseller.repository.SellerRepository;


import java.util.List;
import java.util.Optional;


@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private UserService userService;
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> getSellerById(int id) {
        return sellerRepository.findById(id);
    }

    public Seller createSeller(Seller seller) throws ResourceNotFoundException {
        // Ensure that the user exists before saving the seller
        Integer userId = seller.getUser ().getId(); // Correctly get the user ID
        Optional<User> userOptional = userService.findById(userId);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("User  not found with id " + userId);
        }
        // Set the user to the seller
        seller.setUser (userOptional.get());
        return sellerRepository.save(seller);
    }
    
    public void deleteSeller(int id) {
        sellerRepository.deleteById(id);
    }
}