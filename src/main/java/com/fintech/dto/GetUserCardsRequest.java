package com.fintech.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Builder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"ownerId"})
@XmlRootElement(name = "GetUserCardsRequest")
@Builder
public class GetUserCardsRequest {

    protected long ownerId;

    public GetUserCardsRequest() {
    }

    public GetUserCardsRequest(long ownerId) {
        this.ownerId = ownerId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
