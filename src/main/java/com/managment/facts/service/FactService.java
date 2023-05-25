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
    private String quoteApiUrl;

    @Autowired
    public FactService(RestTemplateBuilder builder, FactRepository factRepository) {
        this.restTemplate = builder.build();
        this.factRepository = factRepository;
    }

    /**
     * Saves a quote object to the database.
     *
     * @param quote The quote object to be saved in the database.
     * @return The quote object that has been saved in the database.
     */
    public Fact save(Fact quote) {
        return factRepository.save(quote);
    }

    /**
     * Fetches a random quote from the database, prioritizing quotes with higher likes.
     *
     * @return A random Quote object from the database, prioritizing quotes with higher likes.
     */
    public Fact fetchRandomQuote() {
        return new Fact();
    }

    /**
     * Deletes all quotes from the database.
     */
    public void deleteAll() {
        factRepository.deleteAll();
    }

    /**
     * Finds a quote in the database by its ID.
     *
     * @param id The ID of the quote to find.
     * @return An Optional containing the quote found in the database, or an empty Optional if no quote with the specified ID exists.
     */
    public Optional<Fact> findById(UUID id) {
        return factRepository.findById(id);
    }

    public List<Fact> fetchAllFacts() {
        return factRepository.findAll();
    }

    public List<Fact> fetchAllFactsFilterBy(String search) {
        search = "%" + search + "%";
        return factRepository.findByFactLike(search);
    }

    public void deleteById(UUID id) {
        factRepository.deleteById(id);
    }
}
