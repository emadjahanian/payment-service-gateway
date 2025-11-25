package com.fintech.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARD",schema = "gw_schema")
public class Card  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 19)
        private String cardNumber;

        @Column(nullable = false, length = 16)
        private String maskedCardNumber;

        @Column(nullable = false, length = 5)
        private String expirationDate;

        @Column(nullable = false)
        private String cvv;

        @Column(nullable = false)
        private boolean active = true;

        @Column(nullable = false)
        private boolean blocked = false;

        @Column(nullable = false, updatable = false)
        private LocalDateTime createdAt = LocalDateTime.now();

        private LocalDateTime lastUsedAt;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "owner_id", nullable = false)
        private Owner owner;

        @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Transaction> transactions = new ArrayList<>();

    public Card() {
    }

    public Card(Long id, String cardNumber, String maskedCardNumber, String expirationDate, String cvv, boolean active, boolean blocked, LocalDateTime createdAt, LocalDateTime lastUsedAt, Owner owner, List<Transaction> transactions) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.maskedCardNumber = maskedCardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.active = active;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.lastUsedAt = lastUsedAt;
        this.owner = owner;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUsedAt() {
        return lastUsedAt;
    }

    public void setLastUsedAt(LocalDateTime lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
