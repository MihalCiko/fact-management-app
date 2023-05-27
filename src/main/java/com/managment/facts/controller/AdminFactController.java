package com.managment.facts.controller;

import com.managment.facts.entity.Fact;
import com.managment.facts.service.FactProviderService;
import com.managment.facts.service.FactService;
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
    Logger logger = LoggerFactory.getLogger(AdminFactController.class);

    @Autowired
    private FactService factService;

    @Autowired
    private FactProviderService factProviderService;

    /**
     Generates and stores random facts in the database by hitting an external API.
     */
    @PostMapping("/fact/generate/{count}")
    public List<Fact> generateFacts(@PathVariable("count") int count) {
        return this.factProviderService.generate(count);
    }

    /**
     Resets the facts database by deleting all existing facts.
     */
    @DeleteMapping("/fact/reset")
    public ResponseEntity<Void> reset() {
        try {
            this.factService.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            logger.error("An error occurred while resetting the fact database", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
