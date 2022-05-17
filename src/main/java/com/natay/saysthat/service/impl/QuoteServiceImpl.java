package com.natay.saysthat.service.impl;

import com.natay.saysthat.model.Quote;
import com.natay.saysthat.repository.QuoteRepository;
import com.natay.saysthat.service.QuoteService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final RestTemplate restTemplate;

    QuoteServiceImpl(QuoteRepository quoteRepository, RestTemplate restTemplate){
        this.quoteRepository = quoteRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public void saveQuote() {
        Quote quote = restTemplate.getForEntity("http://extensions.biryudumkitap.com/quote", Quote.class).getBody();
        Optional<Quote> quoteOptional = getQuoteByQuoteId(quote.getId());
        if (!quoteOptional.isPresent()) {
            quoteRepository.save(quote);
        }

    }

    @Override
    public Set<Quote> getAllQuote() {
        Set<Quote> quoteSet = new HashSet<>();
        quoteRepository.findAll().iterator().forEachRemaining(quoteSet::add);
        return quoteSet;
    }

    @Override
    public Optional<Quote> getQuoteByQuoteId(Long quoteId) {
        return quoteRepository.findByQuoteId(quoteId);
    }

    @Override
    public Long getCount() {
        return quoteRepository.count();
    }
}
