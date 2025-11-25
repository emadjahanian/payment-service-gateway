package com.fintech.repository;

import com.fintech.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findAllByOwnerIdAndActiveTrue(Long ownerId);

    Optional<Card> findByIdAndOwnerIdAndActiveTrue(Long cardId, Long ownerId);
}
