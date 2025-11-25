package com.fintech.rest;

import com.fintech.dto.*;
import com.fintech.service.CardPaymentService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;



@RestController
@RequiredArgsConstructor
public class CardPayRestController implements CardPaymentApi {

    private final CardPaymentService cardPaymentService;

    @Override
    public ResponseEntity<RegisterCardResponse> registerCard(RegisterCardRequest request) {
        RegisterCardResponse resp = cardPaymentService.registerCard(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(resp.getCardId()).toUri();
        return ResponseEntity.created(location).body(resp);
    }

    @Override
    public ResponseEntity<GetUserCardsResponse> getUserCards(Long ownerId) {
        return ResponseEntity.ok(cardPaymentService.getUserCards(ownerId));
    }

    @Override
    public ResponseEntity<CreatePaymentResponse> createPayment(CreatePaymentRequest request) {
        return ResponseEntity.ok(cardPaymentService.createPayment(request));
    }

    @Override
    public ResponseEntity<VerifyPaymentResponse> verifyPayment(VerifyPaymentRequest request) {
        return ResponseEntity.ok(cardPaymentService.verifyPayment(request.getTransactionId()));
    }

    @Override
    @RolesAllowed("admin")
    public ResponseEntity<VerifyPaymentResponse> getTransactionStatus(String transactionId) {
        return ResponseEntity.ok(cardPaymentService.verifyPayment(transactionId));
    }
}
