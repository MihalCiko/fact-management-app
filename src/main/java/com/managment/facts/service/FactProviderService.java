package com.managment.facts.service;

import com.managment.facts.converter.FactConverter;
import com.managment.facts.entity.Fact;
import com.managment.facts.model.FactResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FactProviderService {

    Logger logger = LoggerFactory.getLogger(FactService.class);
    private RestTemplate restTemplate;
    private FactService factService;

    @Value("${fact.api.url}")
    private String factApiUrl;

    @Autowired
    public FactProviderService(RestTemplateBuilder builder, FactService factService) {
        this.restTemplate = builder.build();
        this.factService = factService;
    }

    /**
       Generates and stores random facts in the database by hitting an external API.
     */
    public List<Fact> generate(int count) {
        logger.info("Initiating the process to fetch " + count + " facts");
        List<Fact> factList = new ArrayList<>();
        FactResponse factResponse = this.fetchFactsFromApi();
        for (int i = 0; i < count; i++) {
            Fact fact = FactConverter.convertApiResponseToFact(factResponse.getData().get(i));
            factList.add(factService.save(fact));
        }

        logger.info("Completed fetching and storing facts");

        return factList;
    }

    public FactResponse fetchFactsFromApi() {
        return restTemplate.getForEntity(factApiUrl, FactResponse.class).getBody();
    }
}
