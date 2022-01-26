package com.david.card.repository;

import com.david.card.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends CrudRepository<Card,Long> {
    Optional<List<Card>> findByCustomerId(int id);
}
