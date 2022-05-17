package com.natay.saysthat.repository;

import com.natay.saysthat.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote,Long> {

    @Query("From Quote where quote_id= :id")
    Optional<Quote> findByQuoteId(Long id);

}
