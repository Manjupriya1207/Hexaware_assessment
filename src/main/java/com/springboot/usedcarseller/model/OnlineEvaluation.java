package com.springboot.usedcarseller.model;

import java.time.Year;

import com.springboot.usedcarseller.enums.CarOwnership;

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
@Table(name = "onlineEvaluation")
public class OnlineEvaluation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int EvaluationId;
	@ManyToOne
    @JoinColumn(name = "sellerId", nullable = false)
    private Seller seller;
	
	@Column(nullable=false)
	private String Brand;
	
	@Column(nullable=false)
	private String RtoLocation;
	
	private Year ManufacturingYear;
	
	@Column(nullable=false)
	private String Model;
	
	@Column(nullable=false)
	private String Variant;
	
	private int KmDriven;
	
	@Enumerated(EnumType.STRING)
	private CarOwnership carOwnership;
	
	private String UserLocation;

	public int getEvaluationId() {
		return EvaluationId;
	}

	public void setEvaluationId(int evaluationId) {
		EvaluationId = evaluationId;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getRtoLocation() {
		return RtoLocation;
	}

	public void setRtoLocation(String rtoLocation) {
		RtoLocation = rtoLocation;
	}

	public Year getManufacturingYear() {
		return ManufacturingYear;
	}

	public void setManufacturingYear(Year manufacturingYear) {
		ManufacturingYear = manufacturingYear;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getVariant() {
		return Variant;
	}

	public void setVariant(String variant) {
		Variant = variant;
	}

	public int getKmDriven() {
		return KmDriven;
	}

	public void setKmDriven(int kmDriven) {
		KmDriven = kmDriven;
	}

	public CarOwnership getCarOwnership() {
		return carOwnership;
	}

	public void setCarOwnership(CarOwnership carOwnership) {
		this.carOwnership = carOwnership;
	}

	public String getUserLocation() {
		return UserLocation;
	}

	public void setUserLocation(String userLocation) {
		UserLocation = userLocation;
	}
	
	
}