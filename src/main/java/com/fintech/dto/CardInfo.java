package com.fintech.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Builder;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardInfo", propOrder = {
        "cardId", "maskedCardNumber", "cardHolderName", "expiryDate", "active", "createdAt"
})
@Builder
public class CardInfo {

    protected long cardId;
    protected String maskedCardNumber;
    protected String cardHolderName;
    protected String expiryDate;
    protected boolean active;

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected javax.xml.datatype.XMLGregorianCalendar createdAt;

    public CardInfo() {
    }

    public CardInfo(long cardId, String maskedCardNumber,
                    String cardHolderName, String expiryDate, boolean active, XMLGregorianCalendar createdAt) {
        this.cardId = cardId;
        this.maskedCardNumber = maskedCardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.active = active;
        this.createdAt = createdAt;
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

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(XMLGregorianCalendar createdAt) {
        this.createdAt = createdAt;
    }
}
