package com.fintech.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Builder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"transactionId"})
@XmlRootElement(name = "VerifyPaymentRequest")
@Builder
public class VerifyPaymentRequest {

    @XmlElement(required = true)
    protected String transactionId;

    public VerifyPaymentRequest() {
    }

    public VerifyPaymentRequest(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
