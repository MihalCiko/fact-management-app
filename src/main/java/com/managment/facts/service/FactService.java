package com.managment.facts.service;

import com.managment.facts.entity.Fact;
import com.managment.facts.repository.FactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FactService {
    Logger logger = LoggerFactory.getLogger(FactService.class);
    private RestTemplate restTemplate;
    private FactRepository factRepository;

    @Value("${fact.api.url}")
    private String factApiUrl;

    @Autowired
    public FactService(RestTemplateBuilder builder, FactRepository factRepository) {
        this.restTemplate = builder.build();
        this.factRepository = factRepository;
    }

    /**
      Saves a fact object to the database.
     */
    public Fact save(Fact fact) {
        return factRepository.save(fact);
    }

    /**
       Fetches a random fact from the database, prioritizing facts with higher likes.
     */
    public Fact fetchRandomFact() {
        return new Fact();
    }

    /**
     * Deletes all facts from the database.
     */
    public void deleteAll() {
        factRepository.deleteAll();
    }

    public Optional<Fact> findById(UUID id) {
        return factRepository.findById(id);
    }

    public List<Fact> fetchAllFacts() {
        return factRepository.findAll();
    }

    public List<Fact> fetchAllFactsFilterBy(String search) {
        search = "%" + search + "%";
        return factRepository.findByFact(search);
    }

    public void deleteById(UUID id) {
        factRepository.deleteById(id);
    }
}
