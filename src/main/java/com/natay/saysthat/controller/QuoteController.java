package com.natay.saysthat.controller;

import com.natay.saysthat.model.Quote;
import com.natay.saysthat.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }

    @GetMapping("/saveFromSite" )
    @ResponseStatus(HttpStatus.OK)
    public void saveQuote() {
        quoteService.saveQuote();
    }

    @GetMapping("/count")
    public Long getCount(){
        return quoteService.getCount();
    }
}
