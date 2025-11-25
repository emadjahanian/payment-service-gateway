package com.fintech.service;

import com.fintech.dto.*;

public interface CardPaymentService {

    RegisterCardResponse registerCard(RegisterCardRequest request);

    GetUserCardsResponse getUserCards(Long ownerId);

    CreatePaymentResponse createPayment(CreatePaymentRequest request);

    VerifyPaymentResponse verifyPayment(String transactionId);
}
