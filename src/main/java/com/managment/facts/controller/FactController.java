package com.managment.facts.controller;

import com.managment.facts.entity.Fact;
import com.managment.facts.service.FactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/")
public class FactController {
    Logger logger = LoggerFactory.getLogger(FactController.class);

    @Autowired
    private FactService factService;

    @GetMapping("/home")
    public ModelAndView home(@RequestParam(value = "search", required = false) String searchQuery) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message", "Welcome to our fact page!");

        List<Fact> facts;
        if (searchQuery != null && !searchQuery.isEmpty()) {
            // Perform the search based on the searchQuery
            facts = this.factService.fetchAllFactsFilterBy(searchQuery);
        } else {
            // Fetch all facts if no search query is provided
            facts = this.factService.fetchAllFacts();
        }

        modelAndView.addObject("facts", facts);
        return modelAndView;
    }

    @GetMapping("/fact/{id}")
    public ModelAndView viewFact(@PathVariable("id") String id, Model model) {
        ModelAndView modelAndView = new ModelAndView("fact");
        Fact fact = factService.findById(UUID.fromString(id)).get();

        modelAndView.addObject("fact", fact);
        return modelAndView;
    }

    @PostMapping("/fact/{id}/delete")
    public ModelAndView deleteFact(@PathVariable("id") String id) {
        // Delete the fact with the provided ID using your service layer
        this.factService.deleteById(UUID.fromString(id));

        // Create a new ModelAndView object for redirecting to the home page
        ModelAndView modelAndView = new ModelAndView("redirect:/home");

        return modelAndView;
    }
}
