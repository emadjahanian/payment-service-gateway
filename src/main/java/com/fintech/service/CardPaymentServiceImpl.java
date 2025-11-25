package com.fintech.service;

import com.fintech.dto.*;
import com.fintech.dto.enums.Currency;
import com.fintech.dto.enums.TransactionStatus;
import com.fintech.entity.Card;
import com.fintech.entity.Owner;
import com.fintech.entity.Transaction;
import com.fintech.repository.CardRepository;
import com.fintech.repository.OwnerRepository;
import com.fintech.repository.TransactionRepository;
import com.fintech.utils.XmlDateUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CardPaymentServiceImpl implements CardPaymentService {

    private final OwnerRepository ownerRepository;
    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public RegisterCardResponse registerCard(RegisterCardRequest req) {
        Owner owner = ownerRepository.findById(req.getOwnerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found: " + req.getOwnerId()));

        Card card = new Card();
        card.setCardNumber(req.getCardNumber());
        card.setExpirationDate(req.getExpiryDate());
        card.setOwner(owner);
        card.setActive(true);
        card.setBlocked(false);

        cardRepository.save(card);

        return RegisterCardResponse.builder()
                .cardId(card.getId())
                .maskedCardNumber(card.getMaskedCardNumber())
                .status("SUCCESS")
                .message("Card registered successfully")
                .build();
    }

    @Override
    public GetUserCardsResponse getUserCards(Long ownerId) {
        var cards = cardRepository.findAllByOwnerIdAndActiveTrue(ownerId);

        GetUserCardsResponse resp = new GetUserCardsResponse();
        cards.forEach(c -> {
            CardInfo info = new CardInfo();
            info.setCardId(c.getId());
            info.setMaskedCardNumber(c.getMaskedCardNumber());
            info.setExpiryDate(c.getExpirationDate());
            info.setActive(c.isActive());
            info.setCreatedAt(XmlDateUtil.from(c.getCreatedAt()));
            resp.getCards().add(info);
        });
        return resp;
    }

    @Override
    public CreatePaymentResponse createPayment(CreatePaymentRequest req) {
        Owner owner = ownerRepository.findById(req.getOwnerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));

        Card card = null;
        if (req.getCardId() != null && req.getCardId() > 0) {
            card = cardRepository.findByIdAndOwnerIdAndActiveTrue(req.getCardId(), owner.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Card not found or inactive"));
            card.setLastUsedAt(LocalDateTime.now());
        }

        Transaction tx = new Transaction();
        tx.setTransactionId(UUID.randomUUID().toString());
        tx.setAmount(BigDecimal.valueOf(req.getAmount()));
        tx.setCurrency(req.getCurrency() != null ? req.getCurrency() : Currency.IRR);
        tx.setStatus(TransactionStatus.PENDING);
        tx.setOwner(owner);
        tx.setCard(card);
        tx.setDescription(req.getDescription());

        transactionRepository.save(tx);

        return CreatePaymentResponse.builder()
                .transactionId(tx.getTransactionId())
                .amount(req.getAmount())
                .currency(tx.getCurrency())
                .status(TransactionStatus.PENDING)
                .paymentUrl("https://sandbox.zarinpal.com/pg/StartPay/" + tx.getTransactionId())
                .token(tx.getTransactionId())
                .build();
    }

    @Override
    public VerifyPaymentResponse verifyPayment(String transactionId) {
        Transaction tx = transactionRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found: " + transactionId));

        tx.setStatus(TransactionStatus.SUCCESS);
        if (tx.getCard() != null) {
            tx.getCard().setLastUsedAt(LocalDateTime.now());
        }

        return VerifyPaymentResponse.builder()
                .transactionId(tx.getTransactionId())
                .status(tx.getStatus())
                .amount(tx.getAmount().longValue())
                .currency(tx.getCurrency())
                .referenceId("123456789")
                .cardMasked(tx.getCard() != null ? tx.getCard().getMaskedCardNumber() : null)
                .verifiedAt(XmlDateUtil.from(LocalDateTime.now()))
                .build();
    }
}
