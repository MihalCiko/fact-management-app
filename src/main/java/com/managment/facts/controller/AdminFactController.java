package com.managment.facts.controller;

import com.managment.facts.entity.Fact;
import com.managment.facts.service.FactProviderService;
import com.managment.facts.service.FactService;
import jakarta.validation.constraints.Max;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminFactController {

    //Set a limit on the number of quotes to store with a single request
    public static final int MAX_QUOTES_PER_REQUEST = 100;
    Logger logger = LoggerFactory.getLogger(AdminFactController.class);
    @Autowired
    private FactService factService;

    @Autowired
    private FactProviderService factProviderService;

    /**
     * Generates and stores random quotes in the database by hitting an external API.
     *
     * @param count The total number of quotes to fetch and store in the database.
     * @return A list of quotes that have been fetched and stored in the database.
     */
    @PostMapping("/fact/generate/{count}")
    public List<Fact> generateQuotes(@PathVariable("count") @Max(MAX_QUOTES_PER_REQUEST) int count) {
        return this.factProviderService.generate(count);
    }

    /**
     * Resets the quote database by deleting all existing quotes.
     *
     * @return The HTTP status indicating the success or failure of the reset operation.
     */
    @DeleteMapping("/fact/reset")
    public ResponseEntity<Void> reset() {
        try {
            this.factService.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            logger.error("An error occurred while resetting the quote database", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
