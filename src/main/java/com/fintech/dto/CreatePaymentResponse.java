package com.fintech.dto;

import com.fintech.dto.enums.Currency;
import com.fintech.dto.enums.TransactionStatus;
import jakarta.xml.bind.annotation.*;
import lombok.Builder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "transactionId","amount","currency","status","paymentUrl","token","message"
})
@XmlRootElement(name = "CreatePaymentResponse")
@Builder
public class CreatePaymentResponse {

    @XmlElement(required = true)
    protected String transactionId;
    protected long amount;
    @XmlElement(required = true)
    protected Currency currency;
    @XmlElement(required = true)
    protected TransactionStatus status;
    protected String paymentUrl;
    protected String token;
    protected String message;

    public CreatePaymentResponse(String transactionId, long amount, Currency currency, TransactionStatus status, String paymentUrl, String token, String message) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.paymentUrl = paymentUrl;
        this.token = token;
        this.message = message;
    }

    public CreatePaymentResponse() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
