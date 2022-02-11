package com.ca.scheduler.core.dao;

import com.ca.scheduler.core.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Long> {

    Optional<Card> findByCardNo(String cardNo);
    Optional<Card> findByCardUid(String cardUid);
    Optional<Card> findByCardToken(String cardToken);
    Optional<List<Card>> findAllByCustomer(Long customer);

}
