package com.managment.facts.converter;
import com.managment.facts.entity.Fact;
import com.managment.facts.model.FactBody;

public class FactConverter {
    public static Fact convertApiResponseToFact(FactBody body) {
        Fact fact = new Fact();
        fact.setFact(body.getFact());
        fact.setLength(body.getLength());
        return fact;
    }
}
