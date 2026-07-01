package com.datta.tvaritfinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Partner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long partnerId;

    private String partnerName;

    private String partnerEmail;

    private String phoneNumber;

    private String password;

    private LocalDateTime createdTime;

    public Partner(Long partnerId, String partnerName, String partnerEmail, String phoneNumber, String password, LocalDateTime createdTime) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.partnerEmail = partnerEmail;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.createdTime = createdTime;
    }

    public Partner() {

    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerEmail() {
        return partnerEmail;
    }

    public void setPartnerEmail(String partnerEmail) {
        this.partnerEmail = partnerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }


}
