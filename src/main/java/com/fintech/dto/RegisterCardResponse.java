package com.fintech.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Builder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cardId", "maskedCardNumber", "status", "message"
})
@XmlRootElement(name = "RegisterCardResponse")
@Builder
public class RegisterCardResponse {

    protected long cardId;
    protected String maskedCardNumber;
    protected String status;
    protected String message;

    public RegisterCardResponse() {
    }

    public RegisterCardResponse(long cardId, String maskedCardNumber, String status, String message) {
        this.cardId = cardId;
        this.maskedCardNumber = maskedCardNumber;
        this.status = status;
        this.message = message;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
