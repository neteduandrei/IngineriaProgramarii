package com.b2formeditor.models.databasemodels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jolde on 02/05/2017.
 */
@Document(collection = "Responses")
public class Statistic {
    @Id
    private String id;
    private Object[] answers;

    public Object[] getAnswers() {
        return answers;
    }

    public void setAnswers(Object[] answers) {
        this.answers = answers;
    }
}
