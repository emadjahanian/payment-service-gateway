package com.fintech.dto;

import com.fintech.dto.enums.Currency;
import com.fintech.dto.enums.TransactionStatus;
import jakarta.xml.bind.annotation.*;
import lombok.Builder;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "transactionId","status","amount","currency","referenceId","cardMasked","verifiedAt"
})
@XmlRootElement(name = "VerifyPaymentResponse")
@Builder
public class VerifyPaymentResponse {

    @XmlElement(required = true)
    protected String transactionId;
    @XmlElement(required = true)
    protected TransactionStatus status;
    protected long amount;
    @XmlElement(required = true)
    protected Currency currency;
    protected String referenceId;
    protected String cardMasked;

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected javax.xml.datatype.XMLGregorianCalendar verifiedAt;

    public VerifyPaymentResponse() {
    }

    public VerifyPaymentResponse(String transactionId,
                                 TransactionStatus status, long amount, Currency currency,
                                 String referenceId, String cardMasked, XMLGregorianCalendar verifiedAt) {
        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
        this.currency = currency;
        this.referenceId = referenceId;
        this.cardMasked = cardMasked;
        this.verifiedAt = verifiedAt;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getCardMasked() {
        return cardMasked;
    }

    public void setCardMasked(String cardMasked) {
        this.cardMasked = cardMasked;
    }

    public XMLGregorianCalendar getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(XMLGregorianCalendar verifiedAt) {
        this.verifiedAt = verifiedAt;
    }
}
