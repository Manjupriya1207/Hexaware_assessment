package com.springboot.usedcarseller.model;
import java.time.LocalDateTime;

import com.springboot.usedcarseller.enums.PickupStatus;

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
@Table(name = "pickup")
public class Pickup {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int PickupId;
	
	@ManyToOne
    @JoinColumn(name = "payment_id", nullable = false) 
    private Payment payment;
	
	@Enumerated(EnumType.STRING)
	private PickupStatus pickupStatus=PickupStatus.SCHEDULED;
	
	private LocalDateTime PickupScheduledAt;

	public int getPickupId() {
		return PickupId;
	}

	public void setPickupId(int pickupId) {
		PickupId = pickupId;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public PickupStatus getPickupStatus() {
		return pickupStatus;
	}

	public void setPickupStatus(PickupStatus pickupStatus) {
		this.pickupStatus = pickupStatus;
	}

	public LocalDateTime getPickupScheduledAt() {
		return PickupScheduledAt;
	}

	public void setPickupScheduledAt(LocalDateTime pickupScheduledAt) {
		PickupScheduledAt = pickupScheduledAt;
	}
	



	    

	

}
