package com.springboot.usedcarseller.model;

import java.time.LocalDateTime;

import com.springboot.usedcarseller.enums.InspectionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="doorstepInspection")
public class DoorstepInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inspectionId;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;
    
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    private String address;

    private LocalDateTime scheduledDate;

    @Enumerated(EnumType.STRING)
    private InspectionStatus inspectionStatus = InspectionStatus.SCHEDULED;

    @Column(nullable = false)
    private boolean inspectionVerified;

	

	public int getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(int inspectionId) {
		this.inspectionId = inspectionId;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public InspectionStatus getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(InspectionStatus inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}

	public boolean isInspectionVerified() {
		return inspectionVerified;
	}

	public void setInspectionVerified(boolean inspectionVerified) {
		this.inspectionVerified = inspectionVerified;
	}
	
    
    

	   

}
