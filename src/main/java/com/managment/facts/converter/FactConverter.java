package com.managment.facts.converter;

import com.managment.facts.entity.Fact;
import com.managment.facts.model.FactBody;


public class FactConverter {
    /**
     * Converts the response from an external API, which provides a quote, to a Quote entity.
     *
     * @param responseThe response from the external API containing the quote information.
     * @return A Quote entity representing the converted quote from the API response.
     */
    public static Fact convertApiResponseToFact(FactBody body) {
        Fact fact = new Fact();
        fact.setFact(body.getFact());
        fact.setLength(body.getLength());
        return fact;
    }

}
