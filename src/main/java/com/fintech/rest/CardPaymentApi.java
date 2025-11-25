package com.fintech.rest;

import com.fintech.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/api/v1")
@SecurityRequirement(name = "security_auth")
public interface CardPaymentApi {

    @Operation(summary = "Register a new payment card",
            description = "Stores card securely (masked PAN, no CVV stored)",
            tags = {"Card Management"})
    @ApiResponse(responseCode = "201", description = "Card registered successfully",
            content = @Content(schema = @Schema(implementation = RegisterCardResponse.class)))
    @PostMapping("/cards")
    ResponseEntity<RegisterCardResponse> registerCard(
            @Valid @RequestBody RegisterCardRequest request
    );

    @Operation(summary = "Get all active cards of a user", tags = {"Card Management"})
    @GetMapping("/cards")
    ResponseEntity<GetUserCardsResponse> getUserCards(
            @Parameter(description = "Owner/User ID") @RequestParam("ownerId") Long ownerId
    );

    @Operation(summary = "Create a new payment transaction",
            description = "Returns payment URL (sandbox or real gateway)",
            tags = {"Payment"})
    @PostMapping("/payments")
    ResponseEntity<CreatePaymentResponse> createPayment(
            @Valid @RequestBody CreatePaymentRequest request
    );

    @Operation(summary = "Verify payment after redirect from gateway",
            description = "Should be called manually or via webhook",
            tags = {"Payment"})
    @PostMapping("/payments/verify")
    ResponseEntity<VerifyPaymentResponse> verifyPayment(
            @RequestBody VerifyPaymentRequest request
    );

    @Operation(summary = "Get transaction status by ID", tags = {"Payment"})
    @GetMapping("/payments/{transactionId}")
    ResponseEntity<VerifyPaymentResponse> getTransactionStatus(
            @PathVariable String transactionId
    );
}
