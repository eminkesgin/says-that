package com.natay.saysthat.service;

import com.natay.saysthat.model.Quote;

import java.util.Optional;
import java.util.Set;

public interface QuoteService {
    void saveQuote();
    Set<Quote> getAllQuote();
    Optional<Quote> getQuoteByQuoteId(Long quoteId);
    Long getCount();
}