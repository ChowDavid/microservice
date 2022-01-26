package com.david.card.controller;

import com.david.card.config.CardServiceConfig;
import com.david.card.dto.Customer;
import com.david.card.model.Card;
import com.david.card.repository.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class CardController {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardServiceConfig config;

    @PostMapping("/myCards")
    public List<Card> getCardDetail(@RequestBody Customer customer){
        log.info("Config {}",config);
        Optional<List<Card>> cards=cardRepository.findByCustomerId(customer.getCustomerId());
        if (cards.isPresent()){
            return cards.get();
        } else {
            return Collections.emptyList();
        }
    }
}
