package com.springboot.usedcarseller.model;

import java.time.LocalDateTime;

import com.springboot.usedcarseller.enums.DocumentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int documentId;

    private boolean documentUpload = false;

    private LocalDateTime documentUploadedAt;

    private boolean documentVerified = false;

    private LocalDateTime documentVerifiedAt;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(length = 255)
    private String picturePath;

    @ManyToOne
    @JoinColumn(name = "inspection_id", nullable = false)
    private DoorstepInspection inspection;

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public boolean isDocumentUpload() {
		return documentUpload;
	}

	public void setDocumentUpload(boolean documentUpload) {
		this.documentUpload = documentUpload;
	}

	public LocalDateTime getDocumentUploadedAt() {
		return documentUploadedAt;
	}

	public void setDocumentUploadedAt(LocalDateTime documentUploadedAt) {
		this.documentUploadedAt = documentUploadedAt;
	}

	public boolean isDocumentVerified() {
		return documentVerified;
	}

	public void setDocumentVerified(boolean documentVerified) {
		this.documentVerified = documentVerified;
	}

	public LocalDateTime getDocumentVerifiedAt() {
		return documentVerifiedAt;
	}

	public void setDocumentVerifiedAt(LocalDateTime documentVerifiedAt) {
		this.documentVerifiedAt = documentVerifiedAt;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public DoorstepInspection getInspection() {
		return inspection;
	}

	public void setInspection(DoorstepInspection inspection) {
		this.inspection = inspection;
	}
    }