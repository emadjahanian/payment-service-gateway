package com.fintech.soap;


import com.fintech.dto.*;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

public interface CardPaymentSoapService {

    String NAMESPACE = "http://com.fintech/payment-gateway/cardpay/v1";

    @PayloadRoot(namespace = NAMESPACE, localPart = "RegisterCardRequest")
    @ResponsePayload
    RegisterCardResponse registerCard(@RequestPayload RegisterCardRequest request);

    @PayloadRoot(namespace = NAMESPACE, localPart = "GetUserCardsRequest")
    @ResponsePayload
    GetUserCardsResponse getUserCards(@RequestPayload GetUserCardsRequest request);

    @PayloadRoot(namespace = NAMESPACE, localPart = "CreatePaymentRequest")
    @ResponsePayload
    CreatePaymentResponse createPayment(@RequestPayload CreatePaymentRequest request);

    @PayloadRoot(namespace = NAMESPACE, localPart = "VerifyPaymentRequest")
    @ResponsePayload
    VerifyPaymentResponse verifyPayment(@RequestPayload VerifyPaymentRequest request);
}
