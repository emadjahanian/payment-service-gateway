package com.fintech.dto;

import com.fintech.dto.enums.Currency;
import jakarta.xml.bind.annotation.*;
import lombok.Builder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ownerId","cardId","amount","currency","description","callbackUrl","mobile"
})
@XmlRootElement(name = "CreatePaymentRequest")
@Builder
public class CreatePaymentRequest {

    protected long ownerId;
    protected Long cardId;
    protected long amount;
    @XmlElement(defaultValue = "IRR")
    protected Currency currency;
    protected String description;
    @XmlElement(required = true)
    protected String callbackUrl;
    protected String mobile;

    public CreatePaymentRequest() {
    }

    public CreatePaymentRequest(long ownerId, Long cardId, long amount, Currency currency, String description, String callbackUrl, String mobile) {
        this.ownerId = ownerId;
        this.cardId = cardId;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.callbackUrl = callbackUrl;
        this.mobile = mobile;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
