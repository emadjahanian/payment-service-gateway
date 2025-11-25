package com.fintech.dto;


import jakarta.xml.bind.annotation.*;
import lombok.Builder;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"cards"})
@XmlRootElement(name = "GetUserCardsResponse")
@Builder
public class GetUserCardsResponse {

    @XmlElement(name = "cards")
    protected java.util.List<CardInfo> cards = new java.util.ArrayList<>();

    public GetUserCardsResponse() {
    }

    public GetUserCardsResponse(List<CardInfo> cards) {
        this.cards = cards;
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void setCards(List<CardInfo> cards) {
        this.cards = cards;
    }
}
