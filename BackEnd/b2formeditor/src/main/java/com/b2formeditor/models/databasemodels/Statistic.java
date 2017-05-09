package com.b2formeditor.models.databasemodels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * Created by jolde on 02/05/2017.
 */
@Document(collection = "Responses")
public class Statistic {
    private Map<String, Map<String, Integer>> statistics;

    public Map<String, Map<String, Integer>> getStatistics() {
        return statistics;
    }

    public void setStatistics(Map<String, Map<String, Integer>> statistics) {
        this.statistics = statistics;
    }
}
