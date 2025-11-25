package com.fintech.soap;

import com.fintech.dto.*;
import com.fintech.service.CardPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class CardPayEndpoint implements CardPaymentSoapService {

    private final CardPaymentService cardPaymentService;

    @Override
    @PayloadRoot(namespace = NAMESPACE, localPart = "RegisterCardRequest")
    @ResponsePayload
    public RegisterCardResponse registerCard(@RequestPayload RegisterCardRequest request) {
        return cardPaymentService.registerCard(request);
    }

    @Override
    @PayloadRoot(namespace = NAMESPACE, localPart = "GetUserCardsRequest")
    @ResponsePayload
    public GetUserCardsResponse getUserCards(@RequestPayload GetUserCardsRequest request) {
        return cardPaymentService.getUserCards(request.getOwnerId());
    }

    @Override
    @PayloadRoot(namespace = NAMESPACE, localPart = "CreatePaymentRequest")
    @ResponsePayload
    public CreatePaymentResponse createPayment(@RequestPayload CreatePaymentRequest request) {
        return cardPaymentService.createPayment(request);
    }

    @Override
    @PayloadRoot(namespace = NAMESPACE, localPart = "VerifyPaymentRequest")
    @ResponsePayload
    public VerifyPaymentResponse verifyPayment(@RequestPayload VerifyPaymentRequest request) {
        return cardPaymentService.verifyPayment(request.getTransactionId());
    }
}